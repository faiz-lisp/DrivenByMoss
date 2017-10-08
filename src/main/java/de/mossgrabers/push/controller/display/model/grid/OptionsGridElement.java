// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.push.controller.display.model.grid;

import de.mossgrabers.push.PushConfiguration;

import com.bitwig.extension.api.Color;
import com.bitwig.extension.api.GraphicsOutput;


/**
 * An element in the grid which can display on option on top and on the bottom of the element. In
 * the middle two texts can be displayed. The texts are not clipped horizontally and can reach into
 * the next elements.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class OptionsGridElement extends AbstractGridElement
{
    private final String  headerBottom;
    private final String  headerTop;
    private final String  menuBottomName;
    private final boolean isMenuBottomSelected;
    private final boolean useSmallTopMenu;


    /**
     * Constructor.
     *
     * @param headerTop A header for the top menu options (may span multiple grids), may be null
     * @param menuTopName A name for the to menu, may be null
     * @param isMenuTopSelected Is the top menu selected?
     * @param headerBottom A header for the bottom menu options (may span multiple grids), may be
     *            null
     * @param menuBottomName A name for the bottom menu, may be null
     * @param isMenuBottomSelected Is the bottom menu selected?
     * @param useSmallTopMenu Draw the small version of the top menu if true
     */
    public OptionsGridElement (final String headerTop, final String menuTopName, final boolean isMenuTopSelected, final String headerBottom, final String menuBottomName, final boolean isMenuBottomSelected, final boolean useSmallTopMenu)
    {
        super (menuTopName, isMenuTopSelected, null, null, null, false);
        this.headerTop = headerTop;
        this.headerBottom = headerBottom;
        this.menuBottomName = menuBottomName;
        this.isMenuBottomSelected = isMenuBottomSelected;
        this.useSmallTopMenu = useSmallTopMenu;
    }


    /** {@inheritDoc} */
    @Override
    public void draw (final GraphicsOutput gc, final double left, final double width, final double height, final PushConfiguration configuration)
    {
        final double menuHeight = MENU_HEIGHT * 2;

        if (this.useSmallTopMenu)
            this.drawMenu (gc, left, width, configuration);
        else
            drawLargeMenu (gc, left, 0, width, menuHeight, this.menuName, this.isMenuSelected, configuration);
        drawLargeMenu (gc, left, DISPLAY_HEIGHT - 2 * MENU_HEIGHT, width, menuHeight, this.menuBottomName, this.isMenuBottomSelected, configuration);

        final boolean hasTopHeader = this.headerTop != null && this.headerTop.length () > 0;
        final boolean hasBottomHeader = this.headerBottom != null && this.headerBottom.length () > 0;
        if (!hasTopHeader && !hasBottomHeader)
            return;

        final double headerHeight = (DISPLAY_HEIGHT - 2 * menuHeight) / 2;
        final Color textColor = configuration.getColorText ();
        gc.setFontSize (headerHeight / 2.0);
        if (hasTopHeader)
            drawTextInHeight (gc, this.headerTop, left, menuHeight, headerHeight, textColor);
        if (hasBottomHeader)
            drawTextInHeight (gc, this.headerBottom, left, menuHeight + headerHeight, headerHeight, textColor);
    }


    /**
     * Draws a menu at the top of the element.
     *
     * @param gc The graphics context
     * @param left The left bound of the menus drawing area
     * @param top The top bound of the menu
     * @param width The width of the menu
     * @param height The height of the menu
     * @param menu The menu text
     * @param isSelected True if the menu is selected
     * @param configuration The layout settings to use
     */
    protected static void drawLargeMenu (final GraphicsOutput gc, final double left, final double top, final double width, final double height, final String menu, final boolean isSelected, final PushConfiguration configuration)
    {
        if (menu == null || menu.length () == 0)
            return;

        final Color textColor = configuration.getColorText ();

        gc.setColor (isSelected ? textColor : configuration.getColorBackground ());
        gc.rectangle (left, top, width, height);
        gc.fill ();

        gc.setFontSize (height / 2);
        drawTextInBounds (gc, menu, left, top, width, height, Align.CENTER, isSelected ? configuration.getColorBorder () : textColor);
    }
}