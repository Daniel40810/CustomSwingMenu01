
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Dan40810
 */
public class MyList<E extends Object> extends JList<E>
  {

    private final DefaultListModel model;
    private Color selectedColor;
    private int hoverIndex = -1;

    public MyList()
      {
        model = new DefaultListModel();
        selectedColor = new Color(204, 0, 102);
        setModel(model);
          addMouseListener(new MouseAdapter()
            {
            @Override
            public void mouseExited(MouseEvent me)
              {
                hoverIndex = -1;
                repaint();
              }
              
              });
          addMouseMotionListener(new MouseMotionAdapter()
            {
            @Override
            public void mouseMoved(MouseEvent me)
              {
                checkMouse(me);
              }
              
          });
      }
    
    private void checkMouse(MouseEvent me)
      {
        Point p = me.getPoint();
        int index = locationToIndex(p);
        if(index != hoverIndex)
          {
            hoverIndex = index;
            repaint();
          }
      }

    @Override
    public ListCellRenderer getCellRenderer()
      {
        return new DefaultListCellRenderer()
          {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus)
              {
                ListItem item = new ListItem();
                item.setItem(o);
                item.setBackground(MyList.this.getBackground());
                item.setForeground(MyList.this.getForeground());
                item.setSelected(selected);
                if(index == hoverIndex || selected)
                  {
                    item.setBackground(selectedColor);
                  }
                return item;
              }
          };
      }

    public void addItem(Item item)
      {
        model.addElement(item);
      }

    /**
     * @return the selectedColor
     */
    public Color getSelectedColor()
      {
        return selectedColor;
      }

    /**
     * @param selectedColor the selectedColor to set
     */
    public void setSelectedColor(Color selectedColor)
      {
        this.selectedColor = selectedColor;
      }
  }
