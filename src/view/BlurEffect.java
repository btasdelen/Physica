/**
 * 
 */
package view;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.image.GaussianBlurFilter;
import org.jdesktop.swingx.util.GraphicsUtilities;

/**
 * @author bilal
 *
 */
@SuppressWarnings("serial")
public class BlurEffect extends JPanel {
	
	private JXPanel igm;
    private BufferedImage blurBuffer;
    private BufferedImage backBuffer;
    private float alpha = 0.0f;
	private final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public BlurEffect(JXPanel igm) {
    	setSize(SCREEN_WIDTH-1, SCREEN_HEIGHT);
        setLayout(new GridBagLayout());

        this.igm = igm;
        this.igm.setAlpha(0.0f);
        add(igm, new GridBagConstraints());
    }
    
    private void createBlur() {
        JRootPane root = SwingUtilities.getRootPane(this);
        blurBuffer = GraphicsUtilities.createCompatibleImage(
            getWidth(), getHeight());
        Graphics2D g2 = blurBuffer.createGraphics();
        root.paint(g2);
        g2.dispose();

        backBuffer = blurBuffer;

        blurBuffer = GraphicsUtilities.createThumbnailFast(
            blurBuffer, getWidth() / 2);
        blurBuffer = new GaussianBlurFilter(5).filter(blurBuffer, null);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (isVisible() && blurBuffer != null) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(backBuffer, 0, 0, null);

            g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
            g2.drawImage(blurBuffer, 0, 0, getWidth(), getHeight(), null);
            g2.dispose();
        }
    }
    
    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public void fadeIn() {
        createBlur();

        setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
        	//animate blur effect by changing alpha
            public void run() {
                Animator animator = PropertySetter.createAnimator(
                    400, igm, "alpha", 1.0f);
                animator.setAcceleration(0.2f);
                animator.setDeceleration(0.3f);
                animator.addTarget(
                    new PropertySetter(BlurEffect.this, "alpha", 1.0f));
                animator.start();
            }
        });
    }
    
    public void fadeOut() {

        setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Animator animator = PropertySetter.createAnimator(
                    400, igm, "alpha", 1.0f);
                animator.setAcceleration(0.3f);
                animator.setDeceleration(0.2f);
                animator.addTarget(
                    new PropertySetter(BlurEffect.this, "alpha", .0f));
                animator.start();
            }
            
        });
    }
}


