package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.i;
import java.lang.ref.WeakReference;

public abstract class c {
    protected j FhN = null;
    protected k FhO = null;
    public e FhP = null;
    public e FhQ = null;
    public a FhR = null;
    protected Handler handler = null;
    public int mScene = -1;
    protected WeakReference<Activity> nhy = null;

    public interface a {
        void a(i iVar);
    }

    public abstract void gA();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, j jVar, k kVar, Handler handler2) {
        this.FhN = jVar;
        this.FhO = kVar;
        this.nhy = weakReference;
        this.handler = handler2;
    }

    /* access modifiers changed from: protected */
    public final void flD() {
        if (this.handler != null) {
            this.handler.obtainMessage(4).sendToTarget();
        } else {
            Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* access modifiers changed from: protected */
    public final void flE() {
        if (this.handler != null) {
            this.handler.obtainMessage(5).sendToTarget();
        } else {
            Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    /* access modifiers changed from: protected */
    public final void flF() {
        if (this.handler != null) {
            flE();
            this.handler.obtainMessage(0, this.FhO).sendToTarget();
            return;
        }
        Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* access modifiers changed from: protected */
    public final void flG() {
        if (this.handler != null) {
            flE();
            this.handler.obtainMessage(1, this.FhO).sendToTarget();
            return;
        }
        Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* access modifiers changed from: protected */
    public final void flH() {
        if (this.handler != null) {
            flE();
            this.handler.obtainMessage(2, this.FhO).sendToTarget();
            return;
        }
        Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* access modifiers changed from: protected */
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.handler != null) {
            Message obtainMessage = this.handler.obtainMessage(3);
            Bundle bundle = new Bundle();
            bundle.putStringArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, strArr);
            bundle.putInt("request_code", i2);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    /* access modifiers changed from: protected */
    public final void b(d dVar) {
        if (dVar == null) {
            Log.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (this.handler != null) {
            flE();
            this.handler.obtainMessage(6, dVar).sendToTarget();
        } else {
            Log.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
