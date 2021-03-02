package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a implements d, Runnable {
    private long lDC = 0;
    private long lDD = 0;

    public void run() {
        this.lDD = System.currentTimeMillis();
        YC();
    }

    public final void bjm() {
        this.lDC = System.currentTimeMillis();
        b.Z(this);
    }

    public final void bEy() {
        this.lDC = System.currentTimeMillis();
        YC();
    }

    public void callback() {
        String name = getClass().getName();
        if (name.contains("$")) {
            name.substring(name.lastIndexOf("$") + 1);
            System.currentTimeMillis();
            System.currentTimeMillis();
            this.lDD = 0;
            this.lDC = 0;
        }
    }
}
