package Main;

import javax.swing.Icon;

/**
 *
 * @author Dan40810
 */
public class Item
  {

    /**
     * @return the text
     */
    public String getText()
      {
        return text;
      }

    /**
     * @param text the text to set
     */
    public void setText(String text)
      {
        this.text = text;
      }

    /**
     * @return the icon
     */
    public Icon getIcon()
      {
        return icon;
      }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon)
      {
        this.icon = icon;
      }

    public Item(String text, Icon icon)
      {
        this.text = text;
        this.icon = icon;
      }
    
    public Item()
      {
        
      }

    private String text;
    private Icon icon;
  }
