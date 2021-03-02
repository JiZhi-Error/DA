package org.xwalk.core;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Iterator;

public class XWalkDialogManager {
    public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
    public static final int DIALOG_DECOMPRESSING = 11;
    public static final int DIALOG_DOWNLOADING = 12;
    public static final int DIALOG_DOWNLOAD_ERROR = 6;
    public static final int DIALOG_NEWER_VERSION = 3;
    public static final int DIALOG_NOT_FOUND = 1;
    public static final int DIALOG_OLDER_VERSION = 2;
    public static final int DIALOG_SELECT_STORE = 7;
    public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
    public static final int DIALOG_UNSUPPORTED_STORE = 8;
    private static final String TAG = "XWalkLib";
    private Dialog mActiveDialog;
    private AlertDialog mArchitectureMismatchDialog;
    private Context mContext;
    private ProgressDialog mDecompressingDialog;
    private AlertDialog mDownloadErrorDialog;
    private ProgressDialog mDownloadingDialog;
    private AlertDialog mNewerVersionDialog;
    private AlertDialog mNotFoundDialog;
    private AlertDialog mOlderVersionDialog;
    private AlertDialog mSelectStoreDialog;
    private AlertDialog mSignatureCheckErrorDialog;
    private AlertDialog mUnsupportedStoreDialog;

    static class ButtonAction {
        Runnable mClickAction;
        boolean mMandatory;
        int mWhich;

        ButtonAction(int i2, Runnable runnable, boolean z) {
            this.mWhich = i2;
            this.mClickAction = runnable;
            this.mMandatory = z;
        }
    }

    public XWalkDialogManager(Context context) {
        this.mContext = context;
    }

    public void setAlertDialog(int i2, AlertDialog alertDialog) {
        AppMethodBeat.i(154695);
        if ((alertDialog instanceof ProgressDialog) || (alertDialog instanceof DatePickerDialog) || (alertDialog instanceof TimePickerDialog)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The type of dialog must be AlertDialog");
            AppMethodBeat.o(154695);
            throw illegalArgumentException;
        } else if (i2 == 1) {
            this.mNotFoundDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 2) {
            this.mOlderVersionDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 3) {
            this.mNewerVersionDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 4) {
            this.mArchitectureMismatchDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 5) {
            this.mSignatureCheckErrorDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 6) {
            this.mDownloadErrorDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 7) {
            this.mSelectStoreDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else if (i2 == 8) {
            this.mUnsupportedStoreDialog = alertDialog;
            AppMethodBeat.o(154695);
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i2)));
            AppMethodBeat.o(154695);
            throw illegalArgumentException2;
        }
    }

    public void setProgressDialog(int i2, ProgressDialog progressDialog) {
        AppMethodBeat.i(154696);
        if (i2 == 11) {
            this.mDecompressingDialog = progressDialog;
            AppMethodBeat.o(154696);
        } else if (i2 == 12) {
            this.mDownloadingDialog = progressDialog;
            AppMethodBeat.o(154696);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i2)));
            AppMethodBeat.o(154696);
            throw illegalArgumentException;
        }
    }

    public AlertDialog getAlertDialog(int i2) {
        AppMethodBeat.i(154697);
        if (i2 == 1) {
            if (this.mNotFoundDialog == null) {
                this.mNotFoundDialog = buildAlertDialog();
                setTitle(this.mNotFoundDialog, R.string.heh);
                setMessage(this.mNotFoundDialog, R.string.heg);
                setPositiveButton(this.mNotFoundDialog, R.string.j7_);
                setNegativeButton(this.mNotFoundDialog, R.string.j78);
            }
            AlertDialog alertDialog = this.mNotFoundDialog;
            AppMethodBeat.o(154697);
            return alertDialog;
        } else if (i2 == 2) {
            if (this.mOlderVersionDialog == null) {
                this.mOlderVersionDialog = buildAlertDialog();
                setTitle(this.mOlderVersionDialog, R.string.hej);
                setMessage(this.mOlderVersionDialog, R.string.hei);
                setPositiveButton(this.mOlderVersionDialog, R.string.j7_);
                setNegativeButton(this.mOlderVersionDialog, R.string.j78);
            }
            AlertDialog alertDialog2 = this.mOlderVersionDialog;
            AppMethodBeat.o(154697);
            return alertDialog2;
        } else if (i2 == 3) {
            if (this.mNewerVersionDialog == null) {
                this.mNewerVersionDialog = buildAlertDialog();
                setTitle(this.mNewerVersionDialog, R.string.hef);
                setMessage(this.mNewerVersionDialog, R.string.hee);
                setNegativeButton(this.mNewerVersionDialog, R.string.j78);
            }
            AlertDialog alertDialog3 = this.mNewerVersionDialog;
            AppMethodBeat.o(154697);
            return alertDialog3;
        } else if (i2 == 4) {
            if (this.mArchitectureMismatchDialog == null) {
                this.mArchitectureMismatchDialog = buildAlertDialog();
                setTitle(this.mArchitectureMismatchDialog, R.string.hec);
                setMessage(this.mArchitectureMismatchDialog, R.string.heb);
                setPositiveButton(this.mArchitectureMismatchDialog, R.string.j7_);
                setNegativeButton(this.mArchitectureMismatchDialog, R.string.j78);
            }
            AlertDialog alertDialog4 = this.mArchitectureMismatchDialog;
            AppMethodBeat.o(154697);
            return alertDialog4;
        } else if (i2 == 5) {
            if (this.mSignatureCheckErrorDialog == null) {
                this.mSignatureCheckErrorDialog = buildAlertDialog();
                setTitle(this.mSignatureCheckErrorDialog, R.string.hem);
                setMessage(this.mSignatureCheckErrorDialog, R.string.hel);
                setNegativeButton(this.mSignatureCheckErrorDialog, R.string.j78);
            }
            AlertDialog alertDialog5 = this.mSignatureCheckErrorDialog;
            AppMethodBeat.o(154697);
            return alertDialog5;
        } else if (i2 == 6) {
            if (this.mDownloadErrorDialog == null) {
                this.mDownloadErrorDialog = buildAlertDialog();
                setTitle(this.mDownloadErrorDialog, R.string.bk3);
                setMessage(this.mDownloadErrorDialog, R.string.bnq);
                setPositiveButton(this.mDownloadErrorDialog, R.string.j7a);
                setNegativeButton(this.mDownloadErrorDialog, R.string.j77);
            }
            AlertDialog alertDialog6 = this.mDownloadErrorDialog;
            AppMethodBeat.o(154697);
            return alertDialog6;
        } else if (i2 == 7) {
            if (this.mSelectStoreDialog == null) {
                this.mSelectStoreDialog = buildAlertDialog();
                setTitle(this.mSelectStoreDialog, R.string.bk3);
                setPositiveButton(this.mSelectStoreDialog, R.string.j79);
            }
            AlertDialog alertDialog7 = this.mSelectStoreDialog;
            AppMethodBeat.o(154697);
            return alertDialog7;
        } else if (i2 == 8) {
            if (this.mUnsupportedStoreDialog == null) {
                this.mUnsupportedStoreDialog = buildAlertDialog();
                setTitle(this.mUnsupportedStoreDialog, R.string.bk3);
                setMessage(this.mUnsupportedStoreDialog, R.string.hsh);
                setNegativeButton(this.mUnsupportedStoreDialog, R.string.j78);
            }
            AlertDialog alertDialog8 = this.mUnsupportedStoreDialog;
            AppMethodBeat.o(154697);
            return alertDialog8;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i2)));
            AppMethodBeat.o(154697);
            throw illegalArgumentException;
        }
    }

    public ProgressDialog getProgressDialog(int i2) {
        AppMethodBeat.i(154698);
        if (i2 == 11) {
            if (this.mDecompressingDialog == null) {
                this.mDecompressingDialog = buildProgressDialog();
                setTitle(this.mDecompressingDialog, R.string.bk3);
                setMessage(this.mDecompressingDialog, R.string.bkz);
                setNegativeButton(this.mDecompressingDialog, R.string.j77);
                this.mDecompressingDialog.setProgressStyle(0);
            }
            ProgressDialog progressDialog = this.mDecompressingDialog;
            AppMethodBeat.o(154698);
            return progressDialog;
        } else if (i2 == 12) {
            if (this.mDownloadingDialog == null) {
                this.mDownloadingDialog = buildProgressDialog();
                setTitle(this.mDownloadingDialog, R.string.bk3);
                setMessage(this.mDownloadingDialog, R.string.bo4);
                setNegativeButton(this.mDownloadingDialog, R.string.j77);
                this.mDownloadingDialog.setProgressStyle(1);
            }
            ProgressDialog progressDialog2 = this.mDownloadingDialog;
            AppMethodBeat.o(154698);
            return progressDialog2;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(i2)));
            AppMethodBeat.o(154698);
            throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: package-private */
    public void showInitializationError(int i2, Runnable runnable, Runnable runnable2) {
        AlertDialog alertDialog;
        AppMethodBeat.i(154699);
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        if (i2 == 2) {
            alertDialog = getAlertDialog(1);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i2 == 3) {
            alertDialog = getAlertDialog(2);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i2 == 4) {
            alertDialog = getAlertDialog(3);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else if (i2 == 6) {
            alertDialog = getAlertDialog(4);
            arrayList.add(new ButtonAction(-1, runnable2, true));
            arrayList.add(new ButtonAction(-2, runnable, false));
        } else if (i2 == 7) {
            alertDialog = getAlertDialog(5);
            arrayList.add(new ButtonAction(-2, runnable, true));
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid status ".concat(String.valueOf(i2)));
            AppMethodBeat.o(154699);
            throw illegalArgumentException;
        }
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(154699);
    }

    /* access modifiers changed from: package-private */
    public void showDownloadError(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(154700);
        AlertDialog alertDialog = getAlertDialog(6);
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        arrayList.add(new ButtonAction(-1, runnable2, true));
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(154700);
    }

    /* access modifiers changed from: package-private */
    public void showSelectStore(Runnable runnable, String str) {
        AppMethodBeat.i(154701);
        AlertDialog alertDialog = getAlertDialog(7);
        setMessage(alertDialog, this.mContext.getString(R.string.giu).replace("STORE_NAME", str));
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        arrayList.add(new ButtonAction(-1, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(154701);
    }

    /* access modifiers changed from: package-private */
    public void showUnsupportedStore(Runnable runnable) {
        AppMethodBeat.i(154702);
        AlertDialog alertDialog = getAlertDialog(8);
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        arrayList.add(new ButtonAction(-2, runnable, true));
        showDialog(alertDialog, arrayList);
        AppMethodBeat.o(154702);
    }

    /* access modifiers changed from: package-private */
    public void showDecompressProgress(Runnable runnable) {
        AppMethodBeat.i(154703);
        ProgressDialog progressDialog = getProgressDialog(11);
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.o(154703);
    }

    /* access modifiers changed from: package-private */
    public void showDownloadProgress(Runnable runnable) {
        AppMethodBeat.i(154704);
        ProgressDialog progressDialog = getProgressDialog(12);
        ArrayList<ButtonAction> arrayList = new ArrayList<>();
        arrayList.add(new ButtonAction(-2, runnable, false));
        showDialog(progressDialog, arrayList);
        AppMethodBeat.o(154704);
    }

    /* access modifiers changed from: package-private */
    public void dismissDialog() {
        AppMethodBeat.i(154705);
        this.mActiveDialog.dismiss();
        this.mActiveDialog = null;
        AppMethodBeat.o(154705);
    }

    /* access modifiers changed from: package-private */
    public void setProgress(int i2, int i3) {
        AppMethodBeat.i(154706);
        ProgressDialog progressDialog = (ProgressDialog) this.mActiveDialog;
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(i3);
        progressDialog.setProgress(i2);
        AppMethodBeat.o(154706);
    }

    /* access modifiers changed from: package-private */
    public boolean isShowingDialog() {
        AppMethodBeat.i(154707);
        if (this.mActiveDialog == null || !this.mActiveDialog.isShowing()) {
            AppMethodBeat.o(154707);
            return false;
        }
        AppMethodBeat.o(154707);
        return true;
    }

    private AlertDialog buildAlertDialog() {
        AppMethodBeat.i(154708);
        AlertDialog create = new AlertDialog.Builder(this.mContext).create();
        create.setIcon(17301543);
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(154708);
        return create;
    }

    private ProgressDialog buildProgressDialog() {
        AppMethodBeat.i(154709);
        ProgressDialog progressDialog = new ProgressDialog(this.mContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(154709);
        return progressDialog;
    }

    private void setTitle(AlertDialog alertDialog, int i2) {
        AppMethodBeat.i(154710);
        alertDialog.setTitle(this.mContext.getString(i2));
        AppMethodBeat.o(154710);
    }

    private void setMessage(AlertDialog alertDialog, int i2) {
        AppMethodBeat.i(154711);
        setMessage(alertDialog, this.mContext.getString(i2));
        AppMethodBeat.o(154711);
    }

    private void setMessage(AlertDialog alertDialog, String str) {
        AppMethodBeat.i(154712);
        String replaceAll = str.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
        if (replaceAll.startsWith("this")) {
            replaceAll = replaceAll.replaceFirst("this", "This");
        }
        alertDialog.setMessage(replaceAll);
        AppMethodBeat.o(154712);
    }

    private void setPositiveButton(AlertDialog alertDialog, int i2) {
        AppMethodBeat.i(154713);
        alertDialog.setButton(-1, this.mContext.getString(i2), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(154713);
    }

    private void setNegativeButton(AlertDialog alertDialog, int i2) {
        AppMethodBeat.i(154714);
        alertDialog.setButton(-2, this.mContext.getString(i2), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(154714);
    }

    private void showDialog(final AlertDialog alertDialog, final ArrayList<ButtonAction> arrayList) {
        AppMethodBeat.i(154715);
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            /* class org.xwalk.core.XWalkDialogManager.AnonymousClass1 */

            public void onShow(DialogInterface dialogInterface) {
                AppMethodBeat.i(154694);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ButtonAction buttonAction = (ButtonAction) it.next();
                    Button button = alertDialog.getButton(buttonAction.mWhich);
                    if (button == null) {
                        if (buttonAction.mMandatory) {
                            RuntimeException runtimeException = new RuntimeException("Button " + buttonAction.mWhich + " is mandatory");
                            AppMethodBeat.o(154694);
                            throw runtimeException;
                        }
                    } else if (buttonAction.mClickAction != null) {
                        final Runnable runnable = buttonAction.mClickAction;
                        button.setOnClickListener(new View.OnClickListener() {
                            /* class org.xwalk.core.XWalkDialogManager.AnonymousClass1.AnonymousClass1 */
                            private byte _hellAccFlag_;

                            public void onClick(View view) {
                                AppMethodBeat.i(154693);
                                b bVar = new b();
                                bVar.bm(view);
                                a.b("org/xwalk/core/XWalkDialogManager$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                XWalkDialogManager.this.dismissDialog();
                                runnable.run();
                                a.a(this, "org/xwalk/core/XWalkDialogManager$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(154693);
                            }
                        });
                    }
                }
                AppMethodBeat.o(154694);
            }
        });
        this.mActiveDialog = alertDialog;
        this.mActiveDialog.show();
        AppMethodBeat.o(154715);
    }
}
