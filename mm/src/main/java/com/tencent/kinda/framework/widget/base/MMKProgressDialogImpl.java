package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.h;

public class MMKProgressDialogImpl implements KProgressDialog {
    private static final String TAG = "MMKProgressDialogImpl";
    private Dialog mDialogImpl;
    private Dialog mLoadingImpl;
    private Dialog mPayProcessImpl;

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showImpl(String str, final boolean z, final VoidCallback voidCallback) {
        AppMethodBeat.i(19098);
        final Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
            AppMethodBeat.o(19098);
            return;
        }
        runInMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(214548);
                MMKProgressDialogImpl.this.mDialogImpl = h.a(context, z, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass1.AnonymousClass1 */

                    public void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(214547);
                        voidCallback.call();
                        MMKProgressDialogImpl.this.mDialogImpl = null;
                        AppMethodBeat.o(214547);
                    }
                });
                if (context instanceof MMActivity) {
                    ((MMActivity) context).addDialog(MMKProgressDialogImpl.this.mDialogImpl);
                }
                AppMethodBeat.o(214548);
            }
        });
        AppMethodBeat.o(19098);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showPayProcessImpl(final boolean z, final VoidCallback voidCallback) {
        AppMethodBeat.i(19099);
        final Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMKProgressDialogImpl showPayProcessImpl() KindaContext.get() return null! case 2");
            AppMethodBeat.o(19099);
            return;
        }
        runInMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(214550);
                MMKProgressDialogImpl.this.mPayProcessImpl = h.a(context, z, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass2.AnonymousClass1 */

                    public void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(214549);
                        voidCallback.call();
                        MMKProgressDialogImpl.this.mPayProcessImpl = null;
                        AppMethodBeat.o(214549);
                    }
                });
                if (context instanceof MMActivity) {
                    ((MMActivity) context).addDialog(MMKProgressDialogImpl.this.mPayProcessImpl);
                }
                AppMethodBeat.o(214550);
            }
        });
        AppMethodBeat.o(19099);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showToast(String str) {
        AppMethodBeat.i(19100);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMKProgressDialogImpl showToast() KindaContext.get() return null! case 3");
            AppMethodBeat.o(19100);
            return;
        }
        com.tencent.mm.ui.base.h.cD(context, str);
        AppMethodBeat.o(19100);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void dismiss() {
        AppMethodBeat.i(19101);
        if (this.mDialogImpl != null && this.mDialogImpl.isShowing()) {
            this.mDialogImpl.dismiss();
        }
        if (this.mPayProcessImpl != null && this.mPayProcessImpl.isShowing()) {
            this.mPayProcessImpl.dismiss();
        }
        if (this.mLoadingImpl != null && this.mLoadingImpl.isShowing()) {
            this.mLoadingImpl.dismiss();
        }
        AppMethodBeat.o(19101);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showTopLoading(String str, final boolean z) {
        AppMethodBeat.i(19102);
        final Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMKProgressDialogImpl can't startLoading because the context is null!");
            AppMethodBeat.o(19102);
            return;
        }
        final String string = context.getString(R.string.inu);
        runInMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(214552);
                MMKProgressDialogImpl.this.mLoadingImpl = h.c(context, string, !z, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass3.AnonymousClass1 */

                    public void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(214551);
                        if (MMKProgressDialogImpl.this.mLoadingImpl != null) {
                            MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                            MMKProgressDialogImpl.this.mLoadingImpl = null;
                        }
                        AppMethodBeat.o(214551);
                    }
                });
                if (context instanceof MMActivity) {
                    ((MMActivity) context).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
                }
                AppMethodBeat.o(214552);
            }
        });
        AppMethodBeat.o(19102);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showNormalLoading(final boolean z) {
        AppMethodBeat.i(170127);
        final Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMKProgressDialogImpl showImpl() KindaContext.get() return null! case 1");
            AppMethodBeat.o(170127);
            return;
        }
        final String string = context.getString(R.string.inv);
        runInMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(214554);
                MMKProgressDialogImpl.this.mLoadingImpl = h.c(context, string, !z, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass4.AnonymousClass1 */

                    public void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(214553);
                        if (MMKProgressDialogImpl.this.mLoadingImpl != null) {
                            MMKProgressDialogImpl.this.mLoadingImpl.dismiss();
                            MMKProgressDialogImpl.this.mLoadingImpl = null;
                        }
                        AppMethodBeat.o(214553);
                    }
                });
                if (context instanceof MMActivity) {
                    ((MMActivity) context).addDialog(MMKProgressDialogImpl.this.mLoadingImpl);
                }
                AppMethodBeat.o(214554);
            }
        });
        AppMethodBeat.o(170127);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showNormalGlobalLoading(boolean z) {
        AppMethodBeat.i(214555);
        showNormalLoading(z);
        AppMethodBeat.o(214555);
    }

    @Override // com.tencent.kinda.gen.KProgressDialog
    public void showPayGlobalLoading(boolean z) {
        AppMethodBeat.i(214556);
        showImpl("", !z, new VoidCallback() {
            /* class com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl.AnonymousClass5 */

            @Override // com.tencent.kinda.gen.VoidCallback
            public void call() {
            }
        });
        AppMethodBeat.o(214556);
    }

    private void runInMainThread(Runnable runnable) {
        AppMethodBeat.i(214557);
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(214557);
            return;
        }
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(214557);
    }
}
