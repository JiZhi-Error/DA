package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KAlertDialog;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class AlertDialogImpl implements KAlertDialog {
    private static final String PATTERN_FILE = "file://";
    private static final String PATTERN_HTTP = "http://";
    private static final String PATTERN_HTTPS = "https://";
    private static final String TAG = "AlertDialogImpl";
    private KindaCacheServiceImpl kindaCacheService = new KindaCacheServiceImpl();
    private Dialog mDialog = null;

    public AlertDialogImpl() {
        AppMethodBeat.i(18742);
        AppMethodBeat.o(18742);
    }

    private void setKindaShowingDialog() {
        AppMethodBeat.i(18743);
        if (this.kindaCacheService != null) {
            this.kindaCacheService.setBool("kindaShowingDialog", true, 0);
            Log.i(TAG, "setKindaShowingDialog");
        }
        AppMethodBeat.o(18743);
    }

    private void setKindaDismissDialog() {
        AppMethodBeat.i(18744);
        if (this.kindaCacheService != null) {
            this.kindaCacheService.setBool("kindaShowingDialog", false, 0);
            Log.i(TAG, "setKindaDismissDialog");
        }
        AppMethodBeat.o(18744);
    }

    private void finishUIPageFragmentActivity() {
        AppMethodBeat.i(18745);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (!(topOrUIPageFragmentActivity instanceof UIPageFragmentActivity)) {
            Log.i(TAG, "finishUIPageFragmentActivity, UIPageFragmentActivity no found!");
            AppMethodBeat.o(18745);
        } else if (((UIPageFragmentActivity) topOrUIPageFragmentActivity).awW()) {
            ((UIPageFragmentActivity) topOrUIPageFragmentActivity).finish();
            AppMethodBeat.o(18745);
        } else {
            Log.i(TAG, "finishUIPageFragmentActivity, UIPageFragmentActivity shouldn't finish!");
            AppMethodBeat.o(18745);
        }
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void dismiss() {
        AppMethodBeat.i(18746);
        if (this.mDialog == null) {
            AppMethodBeat.o(18746);
            return;
        }
        this.mDialog.dismiss();
        this.mDialog = null;
        setKindaDismissDialog();
        finishUIPageFragmentActivity();
        AppMethodBeat.o(18746);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showImpl(String str, String str2, String str3, final VoidCallback voidCallback) {
        AppMethodBeat.i(18747);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showImpl() KindaContext.get() return null! case 1");
            AppMethodBeat.o(18747);
            return;
        }
        this.mDialog = h.a(context, str2, str, str3, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18727);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18727);
            }
        });
        setKindaShowingDialog();
        AppMethodBeat.o(18747);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showImpl(String str, String str2, String str3, String str4, final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18748);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showImpl() KindaContext.get() return null! case 2");
            AppMethodBeat.o(18748);
            return;
        }
        this.mDialog = h.a(context, str2, str, str4, str3, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18734);
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18734);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18735);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18735);
            }
        });
        setKindaShowingDialog();
        AppMethodBeat.o(18748);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showImpl(String str, String str2, String str3, String str4, String str5, final VoidCallback voidCallback, final VoidCallback voidCallback2, final VoidCallback voidCallback3) {
        AppMethodBeat.i(18749);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showImpl() KindaContext.get() return null! case 3");
            AppMethodBeat.o(18749);
            return;
        }
        this.mDialog = h.a(context, str2, str, str3, str4, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18736);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18736);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18737);
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18737);
            }
        });
        this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass6 */

            public void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(18738);
                if (voidCallback3 != null) {
                    voidCallback3.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18738);
            }
        });
        setKindaShowingDialog();
        AppMethodBeat.o(18749);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTipsImpl(String str, String str2, String str3, final VoidCallback voidCallback) {
        AppMethodBeat.i(18750);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showImpl() KindaContext.get() return null! case 4");
            AppMethodBeat.o(18750);
            return;
        }
        this.mDialog = h.a(context, str2, str, str3, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass7 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18739);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18739);
            }
        });
        setKindaShowingDialog();
        AppMethodBeat.o(18750);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTipsImpl(String str, String str2, String str3, String str4, final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18751);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showImpl() KindaContext.get() return null! case 5");
            AppMethodBeat.o(18751);
            return;
        }
        this.mDialog = h.a(context, str2, str, str4, str3, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass8 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18740);
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18740);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass9 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18741);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                AppMethodBeat.o(18741);
            }
        });
        setKindaShowingDialog();
        AppMethodBeat.o(18751);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTipsImpl(String str, String str2, String str3, String str4, String str5, final VoidCallback voidCallback, final VoidCallback voidCallback2, final VoidCallback voidCallback3) {
        AppMethodBeat.i(18752);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 6");
            AppMethodBeat.o(18752);
            return;
        }
        i iVar = new i(context, R.style.a66);
        iVar.setContentView(R.layout.ay0);
        TextView textView = (TextView) iVar.findViewById(R.id.e6v);
        TextView textView2 = (TextView) iVar.findViewById(R.id.e6u);
        TextView textView3 = (TextView) iVar.findViewById(R.id.e6r);
        TextView textView4 = (TextView) iVar.findViewById(R.id.e6s);
        TextView textView5 = (TextView) iVar.findViewById(R.id.e6t);
        if (!b.eP(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        }
        if (!b.eP(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        }
        textView3.setText(str3);
        textView4.setText(str4);
        textView5.setText(str5);
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass10 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18728);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18728);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass11 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18729);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18729);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass12 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18730);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback3 != null) {
                    voidCallback3.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18730);
            }
        });
        iVar.setCancelable(false);
        iVar.show();
        setKindaShowingDialog();
        this.mDialog = iVar;
        AppMethodBeat.o(18752);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTipsImpl(String str, String str2, String str3, String str4, final VoidCallback voidCallback) {
        AppMethodBeat.i(18753);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 7");
            AppMethodBeat.o(18753);
            return;
        }
        i iVar = new i(context, R.style.a66);
        iVar.setContentView(R.layout.axv);
        CdnImageView cdnImageView = (CdnImageView) iVar.findViewById(R.id.bet);
        TextView textView = (TextView) iVar.findViewById(R.id.bfe);
        TextView textView2 = (TextView) iVar.findViewById(R.id.aea);
        ((TextView) iVar.findViewById(R.id.ipq)).setText(str);
        if (str2 != null) {
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                cdnImageView.setUrl(str2);
            } else {
                Drawable drawable = getDrawable(str2);
                if (drawable != null) {
                    cdnImageView.setImageDrawable(drawable);
                }
            }
        }
        textView.setText(str3);
        textView2.setText(str4);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass13 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18731);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18731);
            }
        });
        iVar.setCancelable(false);
        iVar.show();
        setKindaShowingDialog();
        this.mDialog = iVar;
        AppMethodBeat.o(18753);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTipsImpl(String str, String str2, String str3, String str4, String str5, final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18754);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 8");
            AppMethodBeat.o(18754);
            return;
        }
        i iVar = new i(context, R.style.a66);
        iVar.setContentView(R.layout.axw);
        CdnImageView cdnImageView = (CdnImageView) iVar.findViewById(R.id.bet);
        TextView textView = (TextView) iVar.findViewById(R.id.bfe);
        TextView textView2 = (TextView) iVar.findViewById(R.id.ea8);
        TextView textView3 = (TextView) iVar.findViewById(R.id.h6z);
        ((TextView) iVar.findViewById(R.id.ipq)).setText(str);
        if (str2 != null) {
            if (str2.startsWith("http://") || str2.startsWith("https://")) {
                cdnImageView.setUrl(str2);
            } else {
                Drawable drawable = getDrawable(str2);
                if (drawable != null) {
                    cdnImageView.setImageDrawable(drawable);
                }
            }
        }
        textView.setText(str3);
        textView2.setText(str4);
        textView3.setText(str5);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass14 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18732);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18732);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.AlertDialogImpl.AnonymousClass15 */
            private byte _hellAccFlag_;

            public void onClick(View view) {
                AppMethodBeat.i(18733);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/kinda/framework/widget/base/AlertDialogImpl$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AlertDialogImpl.this.dismiss();
                a.a(this, "com/tencent/kinda/framework/widget/base/AlertDialogImpl$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(18733);
            }
        });
        iVar.setCancelable(false);
        iVar.show();
        setKindaShowingDialog();
        this.mDialog = iVar;
        AppMethodBeat.o(18754);
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void setContentAlign(TextAlign textAlign) {
    }

    @Override // com.tencent.kinda.gen.KAlertDialog
    public void showTouchIdAuthViewImpl(String str, VoidStringCallback voidStringCallback, VoidCallback voidCallback, VoidCallback voidCallback2, VoidCallback voidCallback3) {
    }

    private Drawable getDrawable(String str) {
        Bitmap decodeResource;
        AppMethodBeat.i(18755);
        if (str != null) {
            if (str.startsWith(PATTERN_FILE)) {
                decodeResource = BitmapUtil.getBitmapNative(str.replaceFirst(PATTERN_FILE, ""));
            } else {
                int drawableId = ResourcesUtils.getDrawableId(MMApplicationContext.getContext(), str);
                if (drawableId == 0) {
                    drawableId = ResourcesUtils.getResId(MMApplicationContext.getContext(), str, ShareConstants.DEXMODE_RAW);
                }
                decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), drawableId);
                if (decodeResource == null) {
                    try {
                        Drawable drawable = MMApplicationContext.getContext().getResources().getDrawable(drawableId);
                        if (drawable != null) {
                            AppMethodBeat.o(18755);
                            return drawable;
                        }
                    } catch (Resources.NotFoundException e2) {
                    }
                }
            }
            if (decodeResource != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(MMApplicationContext.getContext().getResources(), decodeResource);
                AppMethodBeat.o(18755);
                return bitmapDrawable;
            }
        }
        AppMethodBeat.o(18755);
        return null;
    }
}
