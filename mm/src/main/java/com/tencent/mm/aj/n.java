package com.tencent.mm.aj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class n implements i {
    private Context context;
    private ProgressDialog iLh;
    private Runnable iLi = null;
    private Runnable iLj = null;
    private String path;

    public n(Context context2, String str) {
        AppMethodBeat.i(150310);
        this.context = context2;
        this.path = str;
        this.iLh = null;
        g.azz().a(157, this);
        AppMethodBeat.o(150310);
    }

    public final boolean G(Runnable runnable) {
        boolean z;
        AppMethodBeat.i(150311);
        Assert.assertTrue((this.context == null || this.path == null || this.path.length() <= 0) ? false : true);
        this.iLi = runnable;
        Context context2 = this.context;
        this.context.getString(R.string.zb);
        this.iLh = h.a(context2, this.context.getString(R.string.gw8), true, (DialogInterface.OnCancelListener) null);
        g.azz().a(new m(1, this.path), 0);
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", objArr);
        AppMethodBeat.o(150311);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        a Dk;
        AppMethodBeat.i(150313);
        Log.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        g.azz().b(157, this);
        if (this.iLh != null && this.iLh.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.iLh.dismiss();
            } catch (IllegalArgumentException e2) {
                Log.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e2.getMessage());
            }
        }
        if (i2 == 0 && i3 == 0) {
            Toast.makeText(this.context, (int) R.string.gw7, 0).show();
            if (this.iLi != null) {
                new MMHandler(Looper.getMainLooper()).post(this.iLi);
            }
            AppMethodBeat.o(150313);
            return;
        }
        if (this.iLj != null) {
            new MMHandler(Looper.getMainLooper()).post(this.iLj);
        }
        if (i2 == 4 && (i3 == -100 || i3 == -2023)) {
            AppMethodBeat.o(150313);
        } else if (str != null && str.length() > 0 && (Dk = a.Dk(str)) != null) {
            Dk.a(this.context, null, null);
            AppMethodBeat.o(150313);
        } else if (i2 == 4 && i3 == -4) {
            Toast.makeText(this.context, (int) R.string.bdc, 0).show();
            AppMethodBeat.o(150313);
        } else {
            Toast.makeText(this.context, (int) R.string.gw6, 0).show();
            AppMethodBeat.o(150313);
        }
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(150312);
        Assert.assertTrue((this.context == null || this.path == null || this.path.length() <= 0) ? false : true);
        this.iLi = runnable;
        this.iLj = runnable2;
        g.azz().a(new m(1, this.path, (byte) 0), 0);
        Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.FALSE);
        AppMethodBeat.o(150312);
        return true;
    }
}
