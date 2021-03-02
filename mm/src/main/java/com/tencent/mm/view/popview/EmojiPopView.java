package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.Collections;
import java.util.List;

public class EmojiPopView extends AbstractPopView implements i {
    private EmojiStatusView EGu;
    private View Rqf;
    private View Rqg;
    private View Rqh;
    private View Rqi;
    private View Rqj;
    private TextView Rqk;
    private TextView Rql;
    private WindowManager.LayoutParams Rqm;
    private int Rqn;
    private String Rqo;
    private EmojiInfo Rqp;
    private String Rqq;
    private boolean Rqr;
    private c Rqs;
    private Runnable Rqt;
    private ProgressBar hbv;
    private q qVq;

    public EmojiPopView(Context context) {
        this(context, null);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(105300);
        this.Rqn = -1;
        this.Rqr = false;
        this.Rqt = new Runnable() {
            /* class com.tencent.mm.view.popview.EmojiPopView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(183934);
                EmojiPopView.this.qVq = q.a(EmojiPopView.this.getContext(), EmojiPopView.this.getContext().getString(R.string.bwn), true, 0, null);
                AppMethodBeat.o(183934);
            }
        };
        inflate(context, R.layout.a2e, this);
        this.Rqf = findViewById(R.id.c14);
        this.EGu = (EmojiStatusView) findViewById(R.id.dup);
        this.hbv = (ProgressBar) findViewById(R.id.gl7);
        this.Rqg = findViewById(R.id.c19);
        this.Rqh = findViewById(R.id.c16);
        this.Rqi = findViewById(R.id.c18);
        this.Rqj = findViewById(R.id.c15);
        this.Rqk = (TextView) findViewById(R.id.c17);
        this.Rql = (TextView) findViewById(R.id.c1_);
        setBackground(null);
        this.Rqm = new WindowManager.LayoutParams(2, 262400, 1);
        this.Rqm.width = -2;
        this.Rqm.height = -2;
        this.Rqm.gravity = 8388659;
        this.Rqi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.view.popview.EmojiPopView.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(183935);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = e.hcl;
                e.pl(2);
                EmojiPopView.a(EmojiPopView.this);
                a.a(this, "com/tencent/mm/view/popview/EmojiPopView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183935);
            }
        });
        this.Rqj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.view.popview.EmojiPopView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(183936);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e eVar = e.hcl;
                e.pl(3);
                EmojiPopView.this.Rqr = true;
                EmojiPopView.this.Rqk.setActivated(true);
                EmojiPopView.this.Rqk.setVisibility(0);
                EmojiPopView.this.Rqk.setText(R.string.bt7);
                a.a(this, "com/tencent/mm/view/popview/EmojiPopView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183936);
            }
        });
        this.Rqk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.view.popview.EmojiPopView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(183937);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (EmojiPopView.this.Rqr) {
                    e eVar = e.hcl;
                    e.pl(4);
                    EmojiPopView.e(EmojiPopView.this);
                } else {
                    e eVar2 = e.hcl;
                    e.pl(5);
                    EmojiPopView.f(EmojiPopView.this);
                }
                a.a(this, "com/tencent/mm/view/popview/EmojiPopView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183937);
            }
        });
        if (MMApplicationContext.isMainProcess()) {
            g.aAg().hqi.a(698, this);
        }
        AppMethodBeat.o(105300);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(183939);
        super.onDetachedFromWindow();
        if (MMApplicationContext.isMainProcess()) {
            g.aAg().hqi.b(698, this);
        }
        AppMethodBeat.o(183939);
    }

    public void setPopupType(int i2) {
        AppMethodBeat.i(183940);
        boolean z = !MMApplicationContext.isMainProcess() || i2 == -1 || this.Rqp == null || this.Rqp.NA() || this.Rqp.field_catalog == EmojiGroupInfo.VkO || this.Rqp.hYs() != EmojiInfo.a.STATUS_SUCCESS;
        this.Rqr = false;
        if (z) {
            this.Rqh.setVisibility(8);
            this.Rqi.setVisibility(8);
            this.Rqj.setVisibility(8);
            this.Rqg.setVisibility(8);
            this.Rqk.setVisibility(8);
            this.Rql.setVisibility(8);
            ((ConstraintLayout.LayoutParams) this.EGu.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 28);
            AppMethodBeat.o(183940);
            return;
        }
        ((ConstraintLayout.LayoutParams) this.EGu.getLayoutParams()).goneBottomMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
        if (i2 == 0 || i2 == 1) {
            this.Rqh.setVisibility(0);
            this.Rqi.setVisibility(0);
            this.Rqj.setVisibility(0);
            this.Rqg.setVisibility(0);
            this.Rqk.setVisibility(8);
            this.Rql.setVisibility(8);
        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
            this.Rqh.setVisibility(0);
            this.Rqi.setVisibility(8);
            this.Rqj.setVisibility(8);
            this.Rqg.setVisibility(8);
            this.Rqk.setVisibility(0);
            this.Rql.setVisibility(0);
            if (Util.isNullOrNil(this.Rqp.field_groupId)) {
                this.Rqk.setVisibility(8);
            }
            this.Rqq = ((d) g.ah(d.class)).getProvider().amp(this.Rqo);
            this.Rql.setText(this.Rqq);
            if (Util.isNullOrNil(this.Rqq)) {
                this.Rql.setVisibility(8);
            }
        }
        this.Rqn = i2;
        AppMethodBeat.o(183940);
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105301);
        if (emojiInfo == null) {
            this.EGu.setVisibility(4);
            this.hbv.setVisibility(0);
            Log.i("MicroMsg.EmojiPopView", "emoji is null. set null");
            AppMethodBeat.o(105301);
            return;
        }
        if (!emojiInfo.getMd5().equals(this.Rqo)) {
            this.Rqo = emojiInfo.getMd5();
            this.Rqp = emojiInfo;
            this.EGu.setStatusListener(new EmojiStatusView.b() {
                /* class com.tencent.mm.view.popview.EmojiPopView.AnonymousClass5 */

                @Override // com.tencent.mm.emoji.view.EmojiStatusView.b
                public final void po(int i2) {
                    AppMethodBeat.i(183938);
                    Log.i("MicroMsg.EmojiPopView", "onStatus: %s", Integer.valueOf(i2));
                    if (i2 == 1) {
                        EmojiPopView.this.hbv.setVisibility(8);
                        EmojiPopView.this.EGu.setVisibility(0);
                        AppMethodBeat.o(183938);
                        return;
                    }
                    EmojiPopView.this.EGu.setVisibility(4);
                    EmojiPopView.this.hbv.setVisibility(0);
                    AppMethodBeat.o(183938);
                }
            });
            this.EGu.setEmojiInfo(emojiInfo);
        }
        AppMethodBeat.o(105301);
    }

    @Override // com.tencent.mm.view.popview.AbstractPopView
    public final void dismiss() {
        AppMethodBeat.i(183941);
        super.dismiss();
        hideLoading();
        AppMethodBeat.o(183941);
    }

    private void showLoading() {
        AppMethodBeat.i(183942);
        postDelayed(this.Rqt, 100);
        AppMethodBeat.o(183942);
    }

    private void hideLoading() {
        AppMethodBeat.i(183943);
        removeCallbacks(this.Rqt);
        if (this.qVq != null) {
            this.qVq.dismiss();
        }
        AppMethodBeat.o(183943);
    }

    private void cIh() {
        AppMethodBeat.i(183944);
        h.c(getContext(), getContext().getString(R.string.bwm), "", "", getContext().getString(R.string.w1), null, null);
        AppMethodBeat.o(183944);
    }

    @Override // com.tencent.mm.view.popview.AbstractPopView
    public WindowManager.LayoutParams getWindowLayoutParams() {
        return this.Rqm;
    }

    @Override // com.tencent.mm.view.popview.AbstractPopView
    public final void hI(View view) {
        AppMethodBeat.i(105302);
        kO(view.getContext());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.Rqm.x = iArr[0] - ((getMeasuredWidth() - view.getMeasuredWidth()) / 2);
        this.Rqm.y = (iArr[1] - getMeasuredHeight()) - this.Rqa;
        int i2 = getResources().getDisplayMetrics().widthPixels;
        int measuredWidth = iArr[0] + (view.getMeasuredWidth() / 2);
        if (measuredWidth < getWidth() / 2) {
            this.Rqm.x = measuredWidth - com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
            this.Rqf.setBackgroundResource(R.drawable.emoji_left_popup_bg);
            this.Rqi.setBackgroundResource(R.drawable.emoji_left_popup_left_bg);
            this.Rqj.setBackgroundResource(R.drawable.emoji_left_popup_right_bg);
            this.Rqk.setBackgroundResource(R.drawable.emoji_left_popup_option_all_bg);
            AppMethodBeat.o(105302);
        } else if ((getWidth() / 2) + measuredWidth > i2) {
            this.Rqm.x = (measuredWidth + com.tencent.mm.cb.a.fromDPToPix(getContext(), 32)) - getMeasuredWidth();
            this.Rqf.setBackgroundResource(R.drawable.emoji_right_popup_bg);
            this.Rqi.setBackgroundResource(R.drawable.emoji_right_popup_left_bg);
            this.Rqj.setBackgroundResource(R.drawable.emoji_right_popup_right_bg);
            this.Rqk.setBackgroundResource(R.drawable.emoji_right_popup_option_all_bg);
            AppMethodBeat.o(105302);
        } else {
            this.Rqf.setBackgroundResource(R.drawable.emoji_popup_bg);
            this.Rqi.setBackgroundResource(R.drawable.emoji_popup_left_bg);
            this.Rqj.setBackgroundResource(R.drawable.emoji_popup_right_bg);
            this.Rqk.setBackgroundResource(R.drawable.emoji_popup_option_all_bg);
            AppMethodBeat.o(105302);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(183945);
        List<String> singletonList = Collections.singletonList(this.Rqo);
        Log.i("MicroMsg.EmojiPopView", "onSceneEnd: %s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), this.Rqo, Integer.valueOf(this.Rqn));
        if (this.Rqs != null && qVar == this.Rqs) {
            if (this.Rqs.kfa == 3) {
                if (i2 == 0 && i3 == 0) {
                    if (this.Rqn == 0) {
                        j.auL().dW(true);
                        j.auL().dV(true);
                    } else {
                        j.auL().dY(true);
                    }
                    bj.gCJ().OpN.x(this.Rqn, singletonList);
                    dismiss();
                    AppMethodBeat.o(183945);
                    return;
                }
                cIh();
                hideLoading();
                AppMethodBeat.o(183945);
                return;
            } else if (this.Rqs.kfa == 2) {
                if (i2 == 0 && i3 == 0) {
                    if (this.Rqn == 0) {
                        j.auL().dW(true);
                        j.auL().dV(true);
                    } else {
                        j.auL().dY(true);
                    }
                    bj.gCJ().OpN.I(singletonList, this.Rqn);
                    dismiss();
                    AppMethodBeat.o(183945);
                    return;
                }
                cIh();
                hideLoading();
            }
        }
        AppMethodBeat.o(183945);
    }

    static /* synthetic */ void a(EmojiPopView emojiPopView) {
        AppMethodBeat.i(183946);
        Log.i("MicroMsg.EmojiPopView", "top: %s, %s", emojiPopView.Rqo, Integer.valueOf(emojiPopView.Rqn));
        if (emojiPopView.Rqn == 0 || emojiPopView.Rqn == 1) {
            emojiPopView.showLoading();
            emojiPopView.Rqs = new c(emojiPopView.Rqn, 3, Collections.singletonList(emojiPopView.Rqo));
            g.aAg().hqi.a(emojiPopView.Rqs, 0);
        }
        AppMethodBeat.o(183946);
    }

    static /* synthetic */ void e(EmojiPopView emojiPopView) {
        AppMethodBeat.i(183947);
        Log.i("MicroMsg.EmojiPopView", "delete: %s， %s", emojiPopView.Rqo, Integer.valueOf(emojiPopView.Rqn));
        if (emojiPopView.Rqn == 0 || emojiPopView.Rqn == 1) {
            emojiPopView.showLoading();
            emojiPopView.Rqs = new c(emojiPopView.Rqn, 2, Collections.singletonList(emojiPopView.Rqo));
            g.aAg().hqi.a(emojiPopView.Rqs, 0);
        }
        AppMethodBeat.o(183947);
    }

    static /* synthetic */ void f(EmojiPopView emojiPopView) {
        AppMethodBeat.i(183948);
        if (emojiPopView.Rqp != null) {
            String str = emojiPopView.Rqp.field_groupId;
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 3);
            intent.putExtra("download_entrance_scene", 16);
            intent.putExtra("from_popup", true);
            intent.putExtra("extra_id", str);
            com.tencent.mm.br.c.b(emojiPopView.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
        }
        emojiPopView.dismiss();
        AppMethodBeat.o(183948);
    }
}
