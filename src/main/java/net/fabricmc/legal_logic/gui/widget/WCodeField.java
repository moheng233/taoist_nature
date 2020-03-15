package net.fabricmc.legal_logic.gui.widget;

import net.fabricmc.legal_logic.util.CodeList;
import spinnery.widget.WAbstractTextEditor;
import spinnery.widget.api.WFocusedMouseListener;

@WFocusedMouseListener
public class WCodeField extends WAbstractTextEditor {
    
    public CodeList code;


    @Override
    public void draw() {
        super.draw();
    }

}