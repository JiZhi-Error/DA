package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;

public class OfflineAlertView extends LinearLayout {
    public int AKt = 0;
    boolean AKu = true;
    private a AKv = null;
    CountDownTimer AKw;
    private View contentView = null;
    ViewGroup jLy = null;
    i ptq;

    public interface a {
        void onClose();

        void onShow();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(66351);
        init();
        AppMethodBeat.o(66351);
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(66352);
        init();
        AppMethodBeat.o(66352);
    }

    private void init() {
        AppMethodBeat.i(66353);
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.c9u, this);
        this.jLy = (ViewGroup) this.contentView.findViewById(R.id.g38);
        this.jLy.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        AppMethodBeat.o(66353);
    }

    public void setBlurDockerView(ViewGroup viewGroup) {
    }

    public void setDialogState(a aVar) {
        this.AKv = aVar;
    }

    public final void a(final View view, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.i(66354);
        this.AKt = 2;
        setVisibility(0);
        this.jLy.removeAllViews();
        this.jLy.addView(LayoutInflater.from(getContext()).inflate(R.layout.c_3, (ViewGroup) null));
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass9 */
            final /* synthetic */ int val$type = 2;

            public final void run() {
                AppMethodBeat.i(66343);
                OfflineAlertView.a(OfflineAlertView.this, view, runnable, runnable2);
                AppMethodBeat.o(66343);
            }
        });
        AppMethodBeat.o(66354);
    }

    public final void eE(final View view) {
        AppMethodBeat.i(66355);
        setVisibility(0);
        this.jLy.removeAllViews();
        this.jLy.addView(LayoutInflater.from(getContext()).inflate(R.layout.c_0, (ViewGroup) null));
        h.INSTANCE.a(13750, 1);
        this.AKt = 4;
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass10 */
            final /* synthetic */ int val$type = 4;

            public final void run() {
                AppMethodBeat.i(213622);
                OfflineAlertView.a(OfflineAlertView.this, view);
                AppMethodBeat.o(213622);
            }
        });
        AppMethodBeat.o(66355);
    }

    public final void a(View view, View.OnClickListener onClickListener) {
        AppMethodBeat.i(66356);
        a(view, onClickListener, 6);
        AppMethodBeat.o(66356);
    }

    /* access modifiers changed from: package-private */
    public final void a(final View view, View.OnClickListener onClickListener, int i2) {
        AppMethodBeat.i(66357);
        this.AKt = i2;
        setVisibility(0);
        this.jLy.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.c_6, (ViewGroup) null);
        if (i2 == 6) {
            ((TextView) inflate.findViewById(R.id.ln)).setText(R.string.fia);
        } else if ((i2 == 3 || i2 == 1) && b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            ((TextView) inflate.findViewById(R.id.ln)).setText(R.string.fij);
        }
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.h_4);
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213626);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("wallet_lock_jsapi_scene", 2);
                    c.b(view.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213626);
                }
            });
        }
        this.jLy.addView(inflate);
        ((Button) this.contentView.findViewById(R.id.dt2)).setOnClickListener(onClickListener);
        this.AKu = false;
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(66350);
                Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.AKv != null) {
                    OfflineAlertView.this.AKv.onShow();
                }
                AppMethodBeat.o(66350);
            }
        });
        AppMethodBeat.o(66357);
    }

    public final void b(final View view, View.OnClickListener onClickListener) {
        AppMethodBeat.i(66358);
        this.AKt = 5;
        setVisibility(0);
        this.AKu = false;
        this.jLy.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.c_6, (ViewGroup) null);
        this.jLy.addView(inflate);
        ((TextView) inflate.findViewById(R.id.ln)).setText(R.string.fi8);
        Button button = (Button) inflate.findViewById(R.id.dt2);
        button.setText(R.string.fi7);
        button.setOnClickListener(onClickListener);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.h_4);
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(213614);
                Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.AKv != null) {
                    OfflineAlertView.this.AKv.onShow();
                }
                AppMethodBeat.o(213614);
            }
        });
        AppMethodBeat.o(66358);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(66359);
        if (getVisibility() == 0) {
            AppMethodBeat.o(66359);
            return true;
        }
        AppMethodBeat.o(66359);
        return false;
    }

    public final boolean TY(int i2) {
        AppMethodBeat.i(66360);
        if (!isShowing()) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == this.AKt) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 2 && (this.AKt == 3 || this.AKt == 4 || this.AKt == 2 || this.AKt == 5)) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 5 && this.AKt == 4) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 6) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 7) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 8 && (this.AKt == 5 || this.AKt == 4 || this.AKt == 2)) {
            AppMethodBeat.o(66360);
            return true;
        } else if (i2 == 3) {
            AppMethodBeat.o(66360);
            return true;
        } else {
            AppMethodBeat.o(66360);
            return false;
        }
    }

    public final void a(final View view, final r rVar) {
        r.a aVar;
        AppMethodBeat.i(213627);
        this.AKt = 8;
        setVisibility(0);
        this.AKu = false;
        this.jLy.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.c_1, this.jLy, false);
        this.jLy.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.f6p);
        TextView textView2 = (TextView) inflate.findViewById(R.id.id5);
        Button button = (Button) inflate.findViewById(R.id.dt2);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.du_);
        weImageView.setImageResource(R.raw.icons_outlined_info);
        weImageView.setIconColor(getResources().getColor(R.color.aei));
        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if (currentLanguage.equals(LocaleUtil.CHINA) || currentLanguage.equals(LocaleUtil.HONGKONG) || currentLanguage.equals(LocaleUtil.TAIWAN)) {
            aVar = a(rVar, currentLanguage);
        } else {
            aVar = a(rVar, LocaleUtil.ENGLISH);
        }
        if (aVar != null) {
            textView.setText(aVar.HYt);
            textView2.setText(aVar.HYu);
            button.setText(aVar.HYz);
        }
        button.setTextColor(getResources().getColor(R.color.jq));
        button.setBackgroundResource(R.drawable.k7);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(213620);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (rVar.pTI == 2) {
                    f.bn(OfflineAlertView.this.getContext(), rVar.url);
                } else if (rVar.pTI == 3) {
                    f.u(rVar.HWN, rVar.HWO, 0, 1000);
                }
                h.INSTANCE.a(20258, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213620);
            }
        });
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(213621);
                Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                }
                if (OfflineAlertView.this.AKv != null) {
                    OfflineAlertView.this.AKv.onShow();
                }
                AppMethodBeat.o(213621);
            }
        });
        AppMethodBeat.o(213627);
    }

    private static r.a a(r rVar, String str) {
        AppMethodBeat.i(213628);
        for (r.a aVar : rVar.HYy) {
            if (aVar.language.equals(str)) {
                AppMethodBeat.o(213628);
                return aVar;
            }
        }
        AppMethodBeat.o(213628);
        return null;
    }

    public final void dismiss() {
        AppMethodBeat.i(66361);
        if (this.jLy != null) {
            this.jLy.removeAllViews();
        }
        setVisibility(8);
        if (this.AKv != null) {
            this.AKv.onClose();
        }
        if (this.AKw != null) {
            this.AKw.cancel();
        }
        if (this.ptq != null) {
            l.b(this.ptq);
        }
        this.AKt = 0;
        this.AKu = true;
        AppMethodBeat.o(66361);
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.i(213629);
        offlineAlertView.setVisibility(0);
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(R.id.dt2);
        if (textView != null) {
            textView.setOnClickListener(new x() {
                /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass13 */

                @Override // com.tencent.mm.ui.x
                public final void czW() {
                    AppMethodBeat.i(66347);
                    runnable.run();
                    AppMethodBeat.o(66347);
                }
            });
        }
        TextView textView2 = (TextView) offlineAlertView.contentView.findViewById(R.id.ihj);
        if (textView2 != null) {
            f.a(textView2, MMApplicationContext.getContext().getString(R.string.ijc), 0, textView2.length(), new e(new e.a() {
                /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(213625);
                    runnable2.run();
                    AppMethodBeat.o(213625);
                }
            }), offlineAlertView.contentView.getContext());
        }
        Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        offlineAlertView.AKu = false;
        if (offlineAlertView.AKv != null) {
            offlineAlertView.AKv.onShow();
        }
        AppMethodBeat.o(213629);
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view) {
        AppMethodBeat.i(213630);
        offlineAlertView.setVisibility(0);
        k.ezn();
        Util.safeParseInt(k.TX(196645));
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(R.id.dt2);
        if (textView != null) {
            textView.setOnClickListener(new x() {
                /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass11 */

                @Override // com.tencent.mm.ui.x
                public final void czW() {
                    AppMethodBeat.i(213623);
                    OfflineAlertView.this.dismiss();
                    AppMethodBeat.o(213623);
                }
            });
        } else {
            Log.e("MicroMsg.OfflineAlertView", "iKnowBtn is null!");
        }
        TextView textView2 = (TextView) offlineAlertView.contentView.findViewById(R.id.ihj);
        if (textView2 != null) {
            textView2.setText(R.string.ij7);
            f.a(textView2, MMApplicationContext.getContext().getString(R.string.ij7), 0, textView2.length(), new e(new e.a() {
                /* class com.tencent.mm.plugin.offline.ui.OfflineAlertView.AnonymousClass12 */

                @Override // com.tencent.mm.wallet_core.ui.e.a
                public final void bmr() {
                    AppMethodBeat.i(213624);
                    com.tencent.mm.plugin.offline.c.a.gK(OfflineAlertView.this.getContext());
                    AppMethodBeat.o(213624);
                }
            }), offlineAlertView.contentView.getContext());
        } else {
            Log.e("MicroMsg.OfflineAlertView", "moreTV is null!");
        }
        Log.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        if (offlineAlertView.AKv != null) {
            offlineAlertView.AKv.onShow();
        }
        AppMethodBeat.o(213630);
    }
}
