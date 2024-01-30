package com.motorola.engine.default_systems;

import java.awt.event.KeyEvent;

public interface InputListener {
    public void onKeyPress(KeyEvent e);
    public void onKeyRelease(KeyEvent e);
}
