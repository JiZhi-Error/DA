package com.tencent.matrix.a.b.a;

import com.tencent.matrix.a.b.c;

public abstract class a implements g {
    protected c cSq;

    @Override // com.tencent.matrix.a.b.a.g
    public void d(c cVar) {
        com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#configure", new Object[0]);
        this.cSq = cVar;
    }

    @Override // com.tencent.matrix.a.b.a.g
    public void Se() {
        com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onTurnOn", new Object[0]);
    }

    @Override // com.tencent.matrix.a.b.a.g
    public void Sf() {
        com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onTurnOff", new Object[0]);
    }

    @Override // com.tencent.matrix.a.b.a.g
    public void onForeground(boolean z) {
        com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onForeground, foreground = ".concat(String.valueOf(z)), new Object[0]);
    }

    @Override // com.tencent.matrix.a.b.a.g
    public void ba(long j2) {
        com.tencent.matrix.g.c.i("Matrix.battery.MonitorFeature", "#onBackgroundCheck, since background started millis = ".concat(String.valueOf(j2)), new Object[0]);
    }
}
