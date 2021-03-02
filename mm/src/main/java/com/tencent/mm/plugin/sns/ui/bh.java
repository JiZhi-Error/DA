package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ay.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

@SuppressLint({"UseSparseArrays"})
public final class bh extends BaseAdapter {
    long DJx = 0;
    private bv EBg = null;
    private bp EHN;
    private Map<Integer, Integer> EHO = new HashMap();
    private g EHP;
    boolean EHQ = false;
    bi EHR;
    bj EHS;
    private d EHT;
    int EHU = Integer.MAX_VALUE;
    int EHV = 0;
    private long EHW = 0;
    private long EHX = 0;
    boolean EHY = false;
    private int EHZ = 0;
    private int EIa = 0;
    int EIb = 0;
    protected View.OnClickListener EIc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(203630);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof TimeLineObject) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (!bh.aRd(timeLineObject.Id)) {
                    h.INSTANCE.kvStat(10090, "1,0");
                    if (!com.tencent.mm.q.a.cC(bh.this.dKq) && !com.tencent.mm.q.a.cA(bh.this.dKq) && !com.tencent.mm.q.a.cE(bh.this.dKq)) {
                        com.tencent.mm.ay.f a2 = i.a(aj.getAccPath(), timeLineObject, 8, com.tencent.mm.ay.h.a(timeLineObject.Id, timeLineObject.ContentObj != null ? timeLineObject.ContentObj.jfy : null));
                        a2.jfn = bh.this.userName;
                        com.tencent.mm.ay.a.c(a2);
                    }
                } else {
                    h.INSTANCE.kvStat(10231, "1");
                    com.tencent.mm.ay.a.bea();
                }
                bh.this.notifyDataSetChanged();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203630);
        }
    };
    Map<Integer, Integer> Enw = new HashMap();
    private Map<Integer, Integer> Enx = new HashMap();
    private int Eny = 0;
    private int Enz = 0;
    String EvF = "";
    private String country;
    private boolean dJM = false;
    private Activity dKq;
    boolean isSearchMode = false;
    List<SnsInfo> list = new ArrayList();
    String sNG = "";
    private String userName = "";
    private boolean xwi = false;
    private String yFy = "";

    public interface d {
        void fiG();
    }

    /* access modifiers changed from: package-private */
    public static abstract class g {
        View.OnClickListener EIM = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(99033);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99033);
                    return;
                }
                Log.d("MicroMsg.SnsphotoAdapter", "sign click");
                g.this.EIQ = (a) view.getTag();
                g.this.iO(g.this.EIQ.ecf, g.this.EIQ.position + 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99033);
            }
        };
        View.OnClickListener EIN = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(99034);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99034);
                    return;
                }
                Log.d("MicroMsg.SnsphotoAdapter", "sign click");
                g.this.EIQ = (a) view.getTag();
                g.this.ZP(g.this.EIQ.ecf);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99034);
            }
        };
        View.OnClickListener EIO = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(99035);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99035);
                    return;
                }
                Log.d("MicroMsg.SnsphotoAdapter", "snssight click");
                g.this.EIQ = (a) view.getTag();
                g.this.iO(g.this.EIQ.ecf, g.this.EIQ.position + 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99035);
            }
        };
        View.OnLongClickListener EIP = new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass7 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(99036);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(99036);
                } else {
                    Log.d("MicroMsg.SnsphotoAdapter", "snsFailPhoto long click");
                    g.this.EIQ = (a) view.getTag();
                    g.this.iP(g.this.EIQ.ecf, g.this.EIQ.position);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$7", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(99036);
                }
                return true;
            }
        };
        public a EIQ = new a();
        View.OnClickListener EnF = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(99030);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99030);
                    return;
                }
                g.this.EIQ = (a) view.getTag();
                g.this.iN(g.this.EIQ.ecf, g.this.EIQ.position);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99030);
            }
        };
        View.OnClickListener EnG = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(99031);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99031);
                    return;
                }
                g.this.EIQ = (a) view.getTag();
                g.this.iN(g.this.EIQ.ecf, g.this.EIQ.position + 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99031);
            }
        };
        View.OnClickListener EnH = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bh.g.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(99032);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99032);
                    return;
                }
                g.this.EIQ = (a) view.getTag();
                g.this.iN(g.this.EIQ.ecf, g.this.EIQ.position + 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99032);
            }
        };

        public static class a {
            public int ecf;
            public int position;
        }

        public abstract void ZP(int i2);

        public abstract void iN(int i2, int i3);

        public abstract void iO(int i2, int i3);

        public abstract void iP(int i2, int i3);
    }

    public final void JR(long j2) {
        if (0 == this.EHW) {
            this.EHW = j2;
            this.EHX = 0;
        }
    }

    public bh(Activity activity, g gVar, String str, final d dVar) {
        AppMethodBeat.i(99037);
        this.userName = str;
        this.dKq = activity;
        this.EHP = gVar;
        this.EHT = dVar;
        this.EBg = aj.faC();
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dKq);
        Log.d("MicroMsg.SnsphotoAdapter", "filterLan temp ".concat(String.valueOf(loadApplicationLanguage)));
        if (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.ENGLISH) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN)) {
            loadApplicationLanguage = loadApplicationLanguage.equals(LocaleUtil.HONGKONG) ? LocaleUtil.TAIWAN : LocaleUtil.ENGLISH;
        }
        this.yFy = loadApplicationLanguage;
        this.country = LocaleUtil.loadApplicationLanguage(this.dKq.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dKq);
        com.tencent.mm.kernel.g.aAi();
        if (this.userName.equals((String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null))) {
            this.dJM = true;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.dJM) {
            this.EHN = bp.gCW();
        } else {
            com.tencent.mm.kernel.g.aAi();
            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                this.EHN = bp.gCX();
            } else {
                this.EHN = bp.gCV();
            }
        }
        this.EHR = new bi(new bi.a() {
            /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.bi.a
            public final void b(List<SnsInfo> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i2, int i3) {
                AppMethodBeat.i(99016);
                if (!bh.this.isSearchMode) {
                    Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                    bh.this.a(list, map, map2, map3, i2, i3);
                    bh.this.sNG = r.Jc(bh.this.list.isEmpty() ? 0 : ((SnsInfo) bh.this.list.get(bh.this.list.size() - 1)).field_snsId);
                }
                AppMethodBeat.o(99016);
            }

            @Override // com.tencent.mm.plugin.sns.ui.bi.a
            public final void fiF() {
                AppMethodBeat.i(99017);
                if (!bh.this.isSearchMode) {
                    bh.c(bh.this);
                    bh.this.notifyDataSetChanged();
                    if (dVar != null) {
                        dVar.fiG();
                    }
                }
                AppMethodBeat.o(99017);
            }
        }, str, this.dJM);
        this.EHS = new bj(new bi.a() {
            /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.ui.bi.a
            public final void b(List<SnsInfo> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i2, int i3) {
                AppMethodBeat.i(99018);
                if (bh.this.isSearchMode) {
                    Log.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                    bh.this.a(list, map, map2, map3, i2, i3);
                    bh.d(bh.this);
                }
                AppMethodBeat.o(99018);
            }

            @Override // com.tencent.mm.plugin.sns.ui.bi.a
            public final void fiF() {
                AppMethodBeat.i(99019);
                if (bh.this.isSearchMode) {
                    bh.c(bh.this);
                    bh.this.notifyDataSetChanged();
                    if (dVar != null) {
                        dVar.fiG();
                    }
                }
                AppMethodBeat.o(99019);
            }
        }, this.dJM);
        JS(0);
        vw(false);
        AppMethodBeat.o(99037);
    }

    public final int getCount() {
        return this.Eny;
    }

    private void a(TextView textView, TextView textView2, long j2) {
        AppMethodBeat.i(99039);
        String str = (String) bm.a(this.dKq, 1000 * j2, !this.yFy.equals(LocaleUtil.ENGLISH));
        if (str.indexOf(":") > 0) {
            CharSequence[] split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            AppMethodBeat.o(99039);
        } else if (str.indexOf(FilePathGenerator.ANDROID_DIR_SEP) > 0) {
            CharSequence[] split2 = str.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split2[1].length() < 2) {
                split2[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO + split2[1];
            }
            split2[0] = bm.K(this.dKq, split2[0], this.yFy);
            textView.setText(split2[0]);
            textView2.setText(split2[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            AppMethodBeat.o(99039);
        } else {
            textView2.setVisibility(0);
            textView2.setText(String.valueOf(str));
            AppMethodBeat.o(99039);
        }
    }

    private boolean aI(int i2, long j2) {
        if (!this.isSearchMode) {
            return true;
        }
        if ((i2 != 0 || this.DJx != j2) && i2 <= 0 && !this.EHY) {
            return false;
        }
        return true;
    }

    private void a(TextView textView, int i2, int i3) {
        AppMethodBeat.i(99040);
        int i4 = i2 / 10000;
        int i5 = i3 / 10000;
        v(textView);
        Log.d("MicroMsg.SnsphotoAdapter", "preHead: %d, preYear: %d", Integer.valueOf(i2), Integer.valueOf(i4));
        if (this.isSearchMode) {
            if (!(i4 == 0 || i5 == i4)) {
                fy(textView);
                textView.setText(String.format(this.dKq.getResources().getString(R.string.hc5), Integer.valueOf(i5)));
                textView.setVisibility(0);
                v(textView);
                AppMethodBeat.o(99040);
                return;
            }
        } else if (i4 == 0) {
            if (bm.getYear() != i5) {
                fy(textView);
                textView.setText(String.format(this.dKq.getResources().getString(R.string.hc5), Integer.valueOf(i5)));
                textView.setVisibility(0);
                v(textView);
                AppMethodBeat.o(99040);
                return;
            }
        } else if (i5 != i4) {
            fy(textView);
            textView.setText(String.format(this.dKq.getResources().getString(R.string.hc5), Integer.valueOf(i5)));
            textView.setVisibility(0);
            v(textView);
        }
        AppMethodBeat.o(99040);
    }

    private void v(final TextView textView) {
        AppMethodBeat.i(99041);
        if (this.EHZ <= 0) {
            textView.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(99020);
                    new Rect();
                    textView.measure(0, 0);
                    bh.this.EHZ = textView.getMeasuredHeight();
                    Log.d("MicroMsg.SnsphotoAdapter", "yearTv height:%s", Integer.valueOf(bh.this.EHZ));
                    AppMethodBeat.o(99020);
                }
            });
        }
        AppMethodBeat.o(99041);
    }

    private void fy(View view) {
        AppMethodBeat.i(99042);
        int intValue = ((Integer) view.getTag()).intValue();
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            if (intValue == 0) {
                layoutParams.topMargin = 0;
                view.setLayoutParams(layoutParams);
                AppMethodBeat.o(99042);
                return;
            }
            layoutParams.topMargin = this.dKq.getResources().getDimensionPixelSize(R.dimen.akj);
            view.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(99042);
    }

    public final int getItemViewType(int i2) {
        int i3;
        String str;
        AppMethodBeat.i(99043);
        if (!this.dJM || i2 != 0 || (this.isSearchMode && (!this.isSearchMode || !this.EHY))) {
            if (this.Enw.get(Integer.valueOf(i2)) != null) {
                i3 = this.Enw.get(Integer.valueOf(i2)).intValue();
            } else {
                i3 = -1;
            }
            if (i3 == -1) {
                Log.e("MicroMsg.SnsphotoAdapter", "unknow error ".concat(String.valueOf(i3)));
                AppMethodBeat.o(99043);
                return 0;
            }
            SnsInfo snsInfo = (SnsInfo) getItem(i3);
            if (snsInfo.getTimeLine().ContentObj.LoU == 1) {
                Log.d("MicroMsg.SnsphotoAdapter", "position " + i2 + " - 0");
                AppMethodBeat.o(99043);
                return 0;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 15) {
                Log.d("MicroMsg.SnsphotoAdapter", "position " + i2 + " - 2");
                AppMethodBeat.o(99043);
                return 2;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 21) {
                AppMethodBeat.o(99043);
                return 3;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 28 || snsInfo.getTimeLine().ContentObj.LoU == 29 || snsInfo.getTimeLine().ContentObj.LoU == 37 || snsInfo.getTimeLine().ContentObj.LoU == 38 || snsInfo.getTimeLine().ContentObj.LoU == 34 || snsInfo.getTimeLine().ContentObj.LoU == 43 || snsInfo.getTimeLine().ContentObj.LoU == 36) {
                AppMethodBeat.o(99043);
                return 4;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 33) {
                AppMethodBeat.o(99043);
                return 5;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 4) {
                if (snsInfo.getTimeLine().AppInfo != null) {
                    str = snsInfo.getTimeLine().AppInfo.Id;
                } else {
                    str = "";
                }
                com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                if (com.tencent.mm.plugin.comm.a.akQ(str)) {
                    AppMethodBeat.o(99043);
                    return 6;
                }
                com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                if (!com.tencent.mm.plugin.comm.a.cAI()) {
                    AppMethodBeat.o(99043);
                    return 1;
                }
                AppMethodBeat.o(99043);
                return 1;
            } else if (snsInfo.getTimeLine().ContentObj.LoU == 42) {
                AppMethodBeat.o(99043);
                return 6;
            } else {
                if (snsInfo.getTimeLine().ContentObj.LoU == 39) {
                    switch (snsInfo.getTimeLine().ContentObj.izD) {
                        case 3:
                        case XWalkEnvironment.TEST_APK_START_VERSION /*{ENCODED_INT: 100000000}*/:
                            AppMethodBeat.o(99043);
                            return 4;
                    }
                }
                AppMethodBeat.o(99043);
                return 1;
            }
        } else {
            Log.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i2 + " - 0");
            AppMethodBeat.o(99043);
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 7;
    }

    @SuppressLint({"ResourceType"})
    private View l(int i2, View view) {
        b bVar;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(203632);
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            b bVar2 = new b();
            view = aa.jQ(this.dKq).inflate(R.layout.bwq, (ViewGroup) null);
            bVar2.EIg = view.findViewById(R.id.bf0);
            bVar2.EIi = (TextView) view.findViewById(R.id.hxj);
            bVar2.EIh = (TextView) view.findViewById(R.id.hyx);
            bVar2.EIj = (TextView) view.findViewById(R.id.i20);
            bVar2.EIm = (TextView) view.findViewById(R.id.h2);
            bVar2.EnP = view.findViewById(R.id.ebv);
            bVar2.EIm = (TextView) view.findViewById(R.id.h2);
            bVar2.EIk = (LinearLayout) view.findViewById(R.id.ebw);
            bVar2.EIl = (ImageView) view.findViewById(R.id.er4);
            bVar2.EnO = (LinearLayout) view.findViewById(R.id.ed1);
            bVar2.pIP = (MMNeat7extView) view.findViewById(R.id.bn6);
            bVar2.EIp = (MMRoundCornerImageView) view.findViewById(R.id.fpz);
            bVar2.titleTv = (TextView) view.findViewById(R.id.fqp);
            bVar2.EIr = (TextView) view.findViewById(R.id.fq0);
            bVar2.EIq = (WeImageView) view.findViewById(R.id.fq9);
            bVar2.EIg.setOnClickListener(this.EHP.EIM);
            bVar2.EIs = view.findViewById(R.id.fbh);
            bVar2.EIn = (LinearLayout) view.findViewById(R.id.day);
            bVar2.EIo = (TextView) view.findViewById(R.id.hzb);
            bVar2.EIo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99023);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("enter_scene", e.k.Ozl);
                    com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                    h.INSTANCE.a(14098, 8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99023);
                }
            });
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.EIj.setTag(Integer.valueOf(i2));
        if (this.Enw.get(Integer.valueOf(i2)) != null) {
            i3 = this.Enw.get(Integer.valueOf(i2)).intValue();
        } else {
            i3 = -1;
        }
        bVar.init();
        if (i3 >= this.Enz || i3 == -1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            view.setVisibility(8);
            AppMethodBeat.o(203632);
        } else {
            view.setVisibility(0);
            if (i3 - 1 >= 0) {
                SnsInfo snsInfo = (SnsInfo) getItem(i3 - 1);
                i4 = snsInfo.getHead();
                an.aQ(snsInfo.getLocalPrivate(), this.dJM);
            } else {
                i4 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(i2)) != null) {
                this.Enx.get(Integer.valueOf(i2)).intValue();
            }
            SnsInfo snsInfo2 = (SnsInfo) getItem(i3);
            TimeLineObject timeLine = snsInfo2.getTimeLine();
            if ((this.dJM && i2 == 0) || i4 == -1 || snsInfo2.getHead() != i4) {
                if (aI(i2, snsInfo2.field_snsId)) {
                    a(bVar.EIh, bVar.EIi, (long) snsInfo2.getCreateTime());
                }
                if (timeLine.Location != null) {
                    if (Util.isNullOrNil(timeLine.Location.kHV)) {
                        str3 = timeLine.Location.kea;
                    } else {
                        str3 = timeLine.Location.kHV;
                    }
                    if (str3 != null && !str3.equals("")) {
                        bVar.EIm.setText(str3);
                        bVar.EIm.setVisibility(0);
                    }
                }
                bVar.EnP.setVisibility(0);
            }
            a(bVar.EIj, i4, snsInfo2.getHead());
            if (this.EHX == 0 || snsInfo2.field_snsId != this.EHX) {
                bVar.EIn.setVisibility(8);
            } else {
                bVar.EIn.setVisibility(0);
            }
            g.a aVar = new g.a();
            aVar.ecf = snsInfo2.localid;
            if (this.EHO.get(Integer.valueOf(i2)) != null) {
                aVar.position = this.EHO.get(Integer.valueOf(i2)).intValue();
            } else {
                aVar.position = 0;
            }
            bVar.EIg.setTag(aVar);
            if (!Util.isNullOrNil(timeLine.ContentDesc)) {
                bVar.pIP.setVisibility(0);
                bVar.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, timeLine.ContentDesc, bVar.pIP.getTextSize()));
            } else {
                bVar.pIP.setVisibility(8);
            }
            bVar.EIk.setVisibility(0);
            bVar.pIP.setMaxLines(1);
            bVar.pIP.getWrappedTextView().setSingleLine(true);
            bVar.EIs.setVisibility(0);
            new bp(this.EHN.tag).hXs = snsInfo2.field_createTime;
            String str4 = "";
            String str5 = "";
            if (timeLine.ContentObj == null || timeLine.ContentObj.jfy == null) {
                str = "";
            } else {
                String str6 = timeLine.ContentObj.jfy.Ktq;
                if (!Util.isNullOrNil(str6)) {
                    Log.i("MicroMsg.SnsphotoAdapter", "has mvInfo:%s", str6);
                    bVar.EIr.setVisibility(0);
                    bVar.EIr.setText(str6 + this.dKq.getString(R.string.f8v));
                }
                str4 = timeLine.ContentObj.jfy.Ktp;
                str = str6;
            }
            if (!Util.isNullOrNil(str4)) {
                str5 = com.tencent.mm.plugin.music.h.b.aIf(str4);
            } else if (!timeLine.ContentObj.LoV.isEmpty()) {
                cnb cnb = timeLine.ContentObj.LoV.get(0);
                if (cnb != null && !Util.isNullOrNil(cnb.Msz)) {
                    str4 = cnb.Msz;
                    str5 = com.tencent.mm.plugin.music.h.b.aIf(cnb.Msz);
                } else if (cnb != null) {
                    q JK = aj.faD().JK((long) cnb.ecf);
                    String str7 = ar.ki(aj.getAccSnsPath(), JK.EmN) + r.aOj(JK.EmN);
                    str5 = str7;
                    str4 = str7;
                }
            }
            Log.i("MicroMsg.SnsphotoAdapter", "coverInfo, posterInfo:%s, coverUrl: %s, coverPath: %s", str, str4, str5);
            bVar.EIp.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvc));
            if (ao.isDarkMode()) {
                bVar.EIp.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvb));
            }
            if (!Util.isNullOrNil(str4)) {
                bVar.EIq.setVisibility(0);
                bVar.EIs.setVisibility(0);
                bVar.titleTv.setMaxLines(1);
                bVar.titleTv.setTextColor(this.dKq.getResources().getColor(R.color.a92));
                String str8 = "";
                if (!timeLine.ContentObj.LoV.isEmpty()) {
                    cnb cnb2 = timeLine.ContentObj.LoV.get(0);
                    cnb2.ecf = snsInfo2.localid;
                    str8 = cnb2.Desc;
                    str2 = cnb2.Title;
                } else {
                    str2 = "";
                }
                c.a aVar2 = new c.a();
                aVar2.fullPath = str5;
                aVar2.jbf = true;
                aVar2.iaT = true;
                aVar2.jbd = true;
                aVar2.hZF = true;
                aVar2.jbx = (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
                com.tencent.mm.av.q.bcV().a(str4, bVar.EIp, aVar2.bdv());
                bVar.EIq.setPressed(false);
                if (aRd(timeLine.Id)) {
                    bVar.EIq.setImageResource(R.raw.icons_outlined_pause2);
                } else {
                    bVar.EIq.setImageResource(R.raw.icons_outlined_play2);
                }
                bVar.EIq.setIconColor(MMApplicationContext.getContext().getResources().getColor(R.color.fo));
                bVar.EIq.setTag(timeLine);
                bVar.EIq.setOnClickListener(this.EIc);
                bVar.EIs.setTag(timeLine);
                bVar.titleTv.setVisibility(0);
                if (!Util.isNullOrNil(str)) {
                    if (!Util.isNullOrNil(str8)) {
                        str2 = str2 + String.format("·%s", str8);
                    }
                    bVar.titleTv.setText(str2);
                } else {
                    bVar.titleTv.setText(str2);
                    if (timeLine.ContentObj.jfy != null && !Util.isNullOrNil(timeLine.ContentObj.jfy.singerName)) {
                        bVar.EIr.setVisibility(0);
                        bVar.EIr.setText(timeLine.ContentObj.jfy.singerName);
                    } else if (!Util.isNullOrNil(str8)) {
                        bVar.EIr.setVisibility(0);
                        bVar.EIr.setText(str8);
                    }
                }
                if (timeLine.ContentObj.jfy == null) {
                    timeLine.ContentObj.jfy = new css();
                }
                timeLine.ContentObj.jfy.jfz = str5;
            } else {
                bVar.EIs.setVisibility(8);
            }
            AppMethodBeat.o(203632);
        }
        return view;
    }

    private View m(int i2, View view) {
        c cVar;
        int i3;
        int i4;
        String str;
        String str2;
        AppMethodBeat.i(163122);
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            c cVar2 = new c();
            view = aa.jQ(this.dKq).inflate(R.layout.bwr, (ViewGroup) null);
            cVar2.EIg = view.findViewById(R.id.bf0);
            cVar2.EIi = (TextView) view.findViewById(R.id.hxj);
            cVar2.EIh = (TextView) view.findViewById(R.id.hyx);
            cVar2.EIj = (TextView) view.findViewById(R.id.i20);
            cVar2.EIm = (TextView) view.findViewById(R.id.h2);
            cVar2.EnP = view.findViewById(R.id.ebv);
            cVar2.EIm = (TextView) view.findViewById(R.id.h2);
            cVar2.EIk = (LinearLayout) view.findViewById(R.id.ebw);
            cVar2.EIl = (ImageView) view.findViewById(R.id.er4);
            cVar2.EnO = (LinearLayout) view.findViewById(R.id.ed1);
            cVar2.pIP = (MMNeat7extView) view.findViewById(R.id.bn6);
            cVar2.EIt = (TagImageView) view.findViewById(R.id.dw4);
            cVar2.uzC = (ImageView) view.findViewById(R.id.i4t);
            cVar2.titleTv = (TextView) view.findViewById(R.id.ir7);
            cVar2.EIr = (TextView) view.findViewById(R.id.h7r);
            cVar2.EIg.setOnClickListener(this.EHP.EIM);
            cVar2.EIs = view.findViewById(R.id.fbh);
            cVar2.EIn = (LinearLayout) view.findViewById(R.id.day);
            cVar2.EIo = (TextView) view.findViewById(R.id.hzb);
            cVar2.EIo.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99024);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("enter_scene", e.k.Ozl);
                    com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                    h.INSTANCE.a(14098, 8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99024);
                }
            });
            view.setTag(cVar2);
            r.b(cVar2.EIt, this.dKq);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        cVar.EIj.setTag(Integer.valueOf(i2));
        if (this.Enw.get(Integer.valueOf(i2)) != null) {
            i3 = this.Enw.get(Integer.valueOf(i2)).intValue();
        } else {
            i3 = -1;
        }
        cVar.init();
        if (i3 >= this.Enz || i3 == -1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            view.setVisibility(8);
            AppMethodBeat.o(163122);
        } else {
            view.setVisibility(0);
            if (i3 - 1 >= 0) {
                SnsInfo snsInfo = (SnsInfo) getItem(i3 - 1);
                i4 = snsInfo.getHead();
                an.aQ(snsInfo.getLocalPrivate(), this.dJM);
            } else {
                i4 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(i2)) != null) {
                this.Enx.get(Integer.valueOf(i2)).intValue();
            }
            SnsInfo snsInfo2 = (SnsInfo) getItem(i3);
            TimeLineObject timeLine = snsInfo2.getTimeLine();
            if ((this.dJM && i2 == 0) || i4 == -1 || snsInfo2.getHead() != i4) {
                if (aI(i2, snsInfo2.field_snsId)) {
                    a(cVar.EIh, cVar.EIi, (long) snsInfo2.getCreateTime());
                }
                if (timeLine.Location != null) {
                    if (Util.isNullOrNil(timeLine.Location.kHV)) {
                        str2 = timeLine.Location.kea;
                    } else {
                        str2 = timeLine.Location.kHV;
                    }
                    if (str2 != null && !str2.equals("")) {
                        cVar.EIm.setText(str2);
                        cVar.EIm.setVisibility(0);
                    }
                }
                cVar.EnP.setVisibility(0);
            }
            a(cVar.EIj, i4, snsInfo2.getHead());
            if (this.EHX == 0 || snsInfo2.field_snsId != this.EHX) {
                cVar.EIn.setVisibility(8);
            } else {
                cVar.EIn.setVisibility(0);
            }
            g.a aVar = new g.a();
            aVar.ecf = snsInfo2.localid;
            if (this.EHO.get(Integer.valueOf(i2)) != null) {
                aVar.position = this.EHO.get(Integer.valueOf(i2)).intValue();
            } else {
                aVar.position = 0;
            }
            cVar.EIg.setTag(aVar);
            if (!Util.isNullOrNil(timeLine.ContentDesc)) {
                cVar.pIP.setVisibility(0);
                cVar.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, timeLine.ContentDesc, cVar.pIP.getTextSize()));
            } else {
                cVar.pIP.setVisibility(8);
            }
            cVar.EIk.setVisibility(0);
            cVar.pIP.setMaxLines(1);
            cVar.pIP.getWrappedTextView().setSingleLine(true);
            cVar.EIs.setVisibility(0);
            int i5 = timeLine.ContentObj.LoU;
            bp bpVar = new bp(this.EHN.tag);
            bpVar.hXs = snsInfo2.field_createTime;
            if (i5 == 2) {
                cVar.pIP.setVisibility(0);
                cVar.pIP.getWrappedTextView().setSingleLine(false);
                cVar.pIP.setMaxLines(2);
                cVar.EIs.setVisibility(8);
            } else if (i5 != 4) {
                cVar.titleTv.setTextColor(this.dKq.getResources().getColor(R.color.FG_0));
                String aRf = fhO() ? bk.aRf(timeLine.ContentObj.Url) : "";
                String str3 = timeLine.ContentObj.Title;
                if (str3 == null || str3.length() <= 40) {
                    str = str3;
                } else {
                    str = str3.substring(0, 40) + "...";
                }
                if (cVar.EIt != null) {
                    cVar.EIt.setOnClickListener(null);
                }
                cVar.uzC.setVisibility(8);
                if (!timeLine.ContentObj.LoV.isEmpty()) {
                    cVar.EIt.setVisibility(0);
                    cnb cnb = timeLine.ContentObj.LoV.get(0);
                    if (timeLine.ContentObj.LoU == 5) {
                        aRf = bk.aRf(cnb.Url);
                        str = cnb.Title;
                        cVar.uzC.setVisibility(0);
                        aj.faL().a(cnb, cVar.EIt, R.raw.app_attach_file_icon_video, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar);
                    } else {
                        aj.faL().a(cnb, cVar.EIt, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar);
                    }
                } else if (timeLine.ContentObj.LoU != 26) {
                    cVar.EIt.setVisibility(8);
                } else {
                    cVar.EIt.setVisibility(0);
                    cVar.EIt.setImageResource(R.raw.note_sns_link_default);
                }
                if (timeLine.ContentObj.LoY != null && timeLine.ContentObj.LoY.iwf == 1) {
                    aRf = MMApplicationContext.getContext().getString(R.string.f3t);
                }
                if (!Util.isNullOrNil(aRf)) {
                    cVar.EIr.setVisibility(0);
                    cVar.EIr.setText(aRf);
                } else {
                    cVar.EIr.setVisibility(8);
                }
                if (!Util.isNullOrNil(str)) {
                    if (cVar.EIr.getVisibility() == 8) {
                        cVar.titleTv.setMaxLines(2);
                    } else {
                        cVar.titleTv.setMaxLines(1);
                    }
                    cVar.titleTv.setVisibility(0);
                    if ((timeLine.contentattr & 1) > 0) {
                        cVar.titleTv.setText(r.a(str, this.dKq, cVar.titleTv));
                    } else {
                        cVar.titleTv.setText(str);
                    }
                } else {
                    cVar.titleTv.setVisibility(8);
                }
                if (timeLine.weappInfo != null && timeLine.weappInfo.subType == 1) {
                    cVar.uzC.setVisibility(0);
                    cVar.uzC.setImageDrawable(cVar.uzC.getContext().getResources().getDrawable(R.raw.shortvideo_play_btn));
                }
            } else if (!timeLine.ContentObj.LoV.isEmpty()) {
                cVar.EIt.setVisibility(0);
                cVar.uzC.setVisibility(0);
                cVar.EIs.setVisibility(0);
                cVar.titleTv.setMaxLines(1);
                cVar.titleTv.setTextColor(this.dKq.getResources().getColor(R.color.a92));
                cnb cnb2 = timeLine.ContentObj.LoV.get(0);
                aj.faL().a(cnb2, cVar.EIt, R.raw.app_attach_file_icon_music, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar);
                cVar.uzC.setPressed(false);
                if (aRd(timeLine.Id)) {
                    cVar.uzC.setImageResource(R.drawable.alq);
                } else {
                    cVar.uzC.setImageResource(R.drawable.am5);
                }
                cVar.EIt.setTag(timeLine);
                cVar.EIt.setOnClickListener(this.EIc);
                cnb2.ecf = snsInfo2.localid;
                cVar.EIs.setTag(timeLine);
                String str4 = cnb2.Desc;
                if (!Util.isNullOrNil(str4)) {
                    cVar.EIr.setVisibility(0);
                    cVar.EIr.setText(str4);
                } else {
                    cVar.EIr.setVisibility(4);
                }
                String str5 = cnb2.Title;
                if (!Util.isNullOrNil(str5)) {
                    cVar.titleTv.setVisibility(0);
                    cVar.titleTv.setTag(aVar);
                    cVar.titleTv.setOnTouchListener(new af());
                    cVar.titleTv.setText(str5);
                } else {
                    cVar.titleTv.setVisibility(8);
                }
            } else {
                cVar.EIs.setVisibility(8);
            }
            view.setDrawingCacheEnabled(false);
            AppMethodBeat.o(163122);
        }
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x060f, code lost:
        if (r10.ContentObj.dME.vXJ == 4) goto L_0x0611;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View n(int r12, android.view.View r13) {
        /*
        // Method dump skipped, instructions count: 2216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.bh.n(int, android.view.View):android.view.View");
    }

    private void a(int i2, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i3, e eVar, int i4) {
        AppMethodBeat.i(99044);
        SnsInfo snsInfo = (SnsInfo) getItem(i2);
        TimeLineObject timeLine = snsInfo.getTimeLine();
        SnsObject C = an.C(snsInfo);
        boolean z = false;
        if (C != null && (((C.ExtFlag & 2) == 2 && C.BlackList != null) || ((C.ExtFlag & 4) == 4 && C.GroupUser != null))) {
            z = true;
        }
        if (this.dJM && C != null && z && this.userName != null && this.userName.equals(snsInfo.getUserName())) {
            textView3.setBackgroundResource(R.drawable.bkl);
            textView3.setVisibility(0);
        }
        if (i3 == 1) {
            if (an.aQ(snsInfo.getLocalPrivate(), this.dJM)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(R.drawable.bkf);
                as Kn = this.EBg.Kn(snsInfo.getUserName());
                String arJ = Kn == null ? "" : Kn.arJ();
                if (!arJ.equals("") && !this.userName.equals(snsInfo.getUserName())) {
                    textView.setVisibility(0);
                    textView.setText(arJ);
                }
            }
        } else if (an.aQ(snsInfo.getLocalPrivate(), this.dJM)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(R.drawable.bkf);
            as Kn2 = this.EBg.Kn(snsInfo.getUserName());
            String arJ2 = Kn2 == null ? "" : Kn2.arJ();
            if (arJ2 != null && !arJ2.equals("") && !this.userName.equals(snsInfo.getUserName())) {
                textView.setVisibility(0);
                textView.setText(arJ2);
            }
        }
        int i5 = snsInfo.localid;
        g.a aVar = new g.a();
        aVar.ecf = i5;
        if (this.EHO.get(Integer.valueOf(i4)) != null) {
            aVar.position = this.EHO.get(Integer.valueOf(i4)).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        bp bpVar = new bp(this.EHN.tag);
        bpVar.hXs = snsInfo.field_createTime;
        if (timeLine.ContentObj.LoU == 1) {
            qFadeImageView.setVisibility(0);
            aj.faL().a(timeLine.ContentObj.LoV, qFadeImageView, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar);
        } else if (timeLine.ContentObj.LoU == 2) {
            textView4.setText(Util.nullAs(timeLine.ContentObj.Desc, ""));
            textView4.setVisibility(0);
        } else if (timeLine.ContentObj.LoU == 21) {
            snsInfo.getPostInfo();
            boolean z2 = true;
            if (this.dJM) {
                z2 = true;
            } else if (m.a(snsInfo, C)) {
                z2 = false;
            }
            qFadeImageView.setVisibility(0);
            aj.faL().a(timeLine.ContentObj.LoV, qFadeImageView, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar, z2);
        }
        if (snsInfo.isInValid() && snsInfo.isDieItem()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(R.drawable.bkd);
            qFadeImageView.setLongClickable(true);
        }
        if (i3 == 1) {
            if (timeLine.ContentObj.LoV == null || timeLine.ContentObj.LoV.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                eVar.EIE.setVisibility(0);
                textView2.setVisibility(0);
                int size = timeLine.ContentObj.LoV.size();
                textView2.setText(this.dKq.getResources().getQuantityString(R.plurals.a4, size, Integer.valueOf(size)));
            }
            String str = timeLine.ContentDesc;
            if (str != null && !str.equals("")) {
                eVar.EIE.setVisibility(0);
                eVar.EIz.setVisibility(0);
                eVar.EIz.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, str, eVar.EIz.getTextSize()));
            }
        }
        AppMethodBeat.o(99044);
    }

    public final void a(List<SnsInfo> list2, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i2, int i3) {
        int head;
        AppMethodBeat.i(99045);
        Log.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
        if (list2 == null || list2.size() <= 0) {
            if (this.EHT != null) {
                this.EHT.fiG();
            }
            AppMethodBeat.o(99045);
            return;
        }
        Log.d("MicroMsg.SnsphotoAdapter", "copy list info");
        int size = list2.size();
        this.list.clear();
        this.Enw.clear();
        this.Enx.clear();
        this.EHO.clear();
        for (int i4 = 0; i4 < size; i4++) {
            this.list.add(SnsInfo.getNewSnsInfo(list2.get(i4)));
        }
        for (Integer num : map.keySet()) {
            int intValue = num.intValue();
            this.Enw.put(Integer.valueOf(intValue), Integer.valueOf(map.get(Integer.valueOf(intValue)).intValue()));
        }
        for (Integer num2 : map2.keySet()) {
            int intValue2 = num2.intValue();
            this.Enx.put(Integer.valueOf(intValue2), Integer.valueOf(map2.get(Integer.valueOf(intValue2)).intValue()));
        }
        for (Integer num3 : map3.keySet()) {
            int intValue3 = num3.intValue();
            this.EHO.put(Integer.valueOf(intValue3), Integer.valueOf(map3.get(Integer.valueOf(intValue3)).intValue()));
        }
        map.clear();
        map2.clear();
        if (this.dJM) {
            head = this.list.size() <= 1 ? Integer.MAX_VALUE : this.list.get(1).getHead();
        } else {
            head = this.list.isEmpty() ? Integer.MAX_VALUE : this.list.get(0).getHead();
        }
        this.EHU = 0;
        for (int i5 = 0; i5 < this.list.size(); i5++) {
            if (!this.dJM || i5 != 0) {
                if (head != this.list.get(i5).getHead()) {
                    break;
                }
                this.EHU = Math.max(this.EHU, this.list.get(i5).getCreateTime());
            }
        }
        if (this.list.isEmpty() || (this.dJM && this.list.size() == 1)) {
            this.EHU = Integer.MAX_VALUE;
        }
        int head2 = this.list.isEmpty() ? 0 : this.list.get(this.list.size() - 1).getHead();
        this.EHV = Integer.MAX_VALUE;
        int size2 = this.list.size() - 1;
        while (size2 >= 0 && head2 != 0 && head2 == this.list.get(size2).getHead()) {
            this.EHV = Math.min(this.EHV, this.list.get(size2).getCreateTime());
            size2--;
        }
        if (this.list.isEmpty()) {
            this.EHV = 0;
        }
        this.Enz = i2;
        this.Eny = i3;
        Log.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i2 + " icount " + i3 + " stTime " + this.EHU + " edTIme " + this.EHV);
        notifyDataSetChanged();
        AppMethodBeat.o(99045);
    }

    private void vw(boolean z) {
        AppMethodBeat.i(99046);
        Log.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.sNG);
        if (this.EHR != null) {
            if (this.isSearchMode) {
                this.EHS.aq(this.EHQ, z);
                AppMethodBeat.o(99046);
                return;
            }
            this.EHR.k(this.sNG, this.EHQ, z);
        }
        AppMethodBeat.o(99046);
    }

    public final void fiD() {
        this.EHY = true;
        if (this.isSearchMode) {
            this.EHS.EIV = true;
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(99047);
        super.notifyDataSetChanged();
        AppMethodBeat.o(99047);
    }

    public final void fiE() {
        AppMethodBeat.i(99049);
        Log.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        JS(this.list.isEmpty() ? 0 : this.list.get(this.list.size() - 1).field_snsId);
        AppMethodBeat.o(99049);
    }

    private void JS(long j2) {
        bh bhVar;
        AppMethodBeat.i(99050);
        String Jc = r.Jc(aj.faO().b(j2, aj.faE().aPn(this.userName), this.userName, this.dJM));
        if (this.EvF.equals("")) {
            bhVar = this;
        } else if (Jc.compareTo(this.EvF) < 0) {
            bhVar = this;
        } else {
            Jc = this.EvF;
            bhVar = this;
        }
        bhVar.sNG = Jc;
        ami feM = aj.faS().aQr(this.userName).feM();
        if (feM.Lvc == 0) {
            AppMethodBeat.o(99050);
            return;
        }
        String Jc2 = r.Jc(feM.Lvc);
        if (this.sNG.equals("")) {
            this.sNG = Jc2;
            AppMethodBeat.o(99050);
            return;
        }
        if (Jc2.compareTo(this.sNG) <= 0) {
            Jc2 = this.sNG;
        }
        this.sNG = Jc2;
        AppMethodBeat.o(99050);
    }

    /* access modifiers changed from: package-private */
    public class a {
        View EIg;
        TextView EIh;
        TextView EIi;
        TextView EIj;
        LinearLayout EIk;
        ImageView EIl;
        TextView EIm;
        LinearLayout EIn;
        TextView EIo;
        LinearLayout EnO;
        View EnP;

        a() {
        }

        public void init() {
            AppMethodBeat.i(99026);
            this.EIh.setVisibility(8);
            this.EIi.setVisibility(8);
            this.EIj.setVisibility(8);
            this.EIk.setVisibility(4);
            this.EIl.setVisibility(4);
            this.EnP.setVisibility(8);
            this.EIm.setVisibility(8);
            this.EIn.setVisibility(8);
            AppMethodBeat.o(99026);
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends a {
        TextView EIA;
        TextView EIB;
        TextView EIC;
        TextView EID;
        View EIE;
        TextView EIF;
        TextView EIG;
        TextView EIH;
        TextView EII;
        TextView EIJ;
        TextView EIK;
        MaskLinearLayout EIL;
        MaskImageView EIv;
        QFadeImageView EIw;
        QFadeImageView EIx;
        QFadeImageView EIy;
        MMNeat7extView EIz;

        e() {
            super();
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.a
        public final void init() {
            AppMethodBeat.i(99028);
            super.init();
            this.EIv.setVisibility(8);
            this.EIx.setVisibility(8);
            this.EIy.setVisibility(8);
            this.EIz.setVisibility(8);
            this.EIA.setVisibility(8);
            this.EIB.setVisibility(8);
            this.EIC.setVisibility(8);
            this.EID.setVisibility(8);
            this.EIE.setVisibility(8);
            this.EIw.setVisibility(8);
            this.EIF.setVisibility(8);
            this.EIG.setVisibility(8);
            this.EIH.setVisibility(8);
            this.EII.setVisibility(8);
            this.EIJ.setVisibility(8);
            this.EIK.setVisibility(8);
            if (com.tencent.mm.cb.a.ez(bh.this.dKq) > 1.0f) {
                this.EIz.setMaxLines(2);
            }
            AppMethodBeat.o(99028);
        }
    }

    /* access modifiers changed from: package-private */
    public class c extends a {
        TextView EIr;
        View EIs;
        TagImageView EIt;
        TextView EIu;
        MMNeat7extView pIP;
        TextView titleTv;
        ImageView uzC;

        c() {
            super();
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.a
        public final void init() {
            AppMethodBeat.i(99027);
            super.init();
            this.pIP.setVisibility(8);
            this.EIt.setVisibility(8);
            if (this.EIu != null) {
                this.EIu.setVisibility(8);
            }
            this.uzC.setVisibility(8);
            this.titleTv.setVisibility(8);
            this.EIr.setVisibility(8);
            AppMethodBeat.o(99027);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends a {
        MMRoundCornerImageView EIp;
        WeImageView EIq;
        TextView EIr;
        View EIs;
        MMNeat7extView pIP;
        TextView titleTv;

        b() {
            super();
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.a
        public final void init() {
            AppMethodBeat.i(203631);
            super.init();
            this.pIP.setVisibility(8);
            this.titleTv.setVisibility(8);
            this.EIr.setVisibility(8);
            AppMethodBeat.o(203631);
        }
    }

    class f extends a {
        View EIE;
        TextView EIF;
        MaskLinearLayout EIL;
        MaskImageView EIv;
        MMNeat7extView EIz;

        f() {
            super();
        }

        @Override // com.tencent.mm.plugin.sns.ui.bh.a
        public final void init() {
            AppMethodBeat.i(99029);
            super.init();
            this.EIv.setVisibility(8);
            this.EIz.setVisibility(8);
            this.EIF.setVisibility(8);
            this.EIE.setVisibility(8);
            if (com.tencent.mm.cb.a.ez(bh.this.dKq) > 1.0f) {
                this.EIz.setMaxLines(2);
            }
            AppMethodBeat.o(99029);
        }
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(99051);
        SnsInfo snsInfo = this.list.get(i2);
        AppMethodBeat.o(99051);
        return snsInfo;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final ArrayList<com.tencent.mm.plugin.sns.j.b> iM(int i2, int i3) {
        AppMethodBeat.i(99052);
        ArrayList<com.tencent.mm.plugin.sns.j.b> arrayList = new ArrayList<>();
        this.EIb = i3;
        for (int i4 = 0; i4 < this.list.size(); i4++) {
            SnsInfo snsInfo = this.list.get(i4);
            int i5 = snsInfo.localid;
            if (!(snsInfo.getTimeLine() == null || snsInfo.getTimeLine().ContentObj == null || snsInfo.getTimeLine().ContentObj.LoV.size() == 0 || !(snsInfo.getTimeLine().ContentObj.LoU == 1 || snsInfo.getTimeLine().ContentObj.LoU == 15))) {
                if (i5 == i2) {
                    this.EIb = arrayList.size();
                }
                Iterator<cnb> it = snsInfo.getTimeLine().ContentObj.LoV.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    com.tencent.mm.plugin.sns.j.b bVar = new com.tencent.mm.plugin.sns.j.b();
                    bVar.ebR = it.next();
                    bVar.parentId = y.bq("sns_table_", (long) i5);
                    bVar.iXu = snsInfo.getCreateTime();
                    bVar.DRJ = i6;
                    arrayList.add(bVar);
                    i6++;
                }
            }
        }
        AppMethodBeat.o(99052);
        return arrayList;
    }

    protected static boolean aRd(String str) {
        AppMethodBeat.i(99054);
        com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
        if (bef == null || !com.tencent.mm.ay.a.e(bef) || !str.equals(bef.jeV) || !com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(99054);
            return false;
        }
        AppMethodBeat.o(99054);
        return true;
    }

    private static boolean fhO() {
        AppMethodBeat.i(163123);
        if ((aq.a.fbx() & 1) <= 0) {
            AppMethodBeat.o(163123);
            return true;
        }
        AppMethodBeat.o(163123);
        return false;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        int i3;
        int i4;
        String str;
        e eVar;
        int i5;
        String str2;
        f fVar;
        int i6;
        int i7;
        String str3;
        e eVar2;
        int i8;
        int i9;
        String str4;
        AppMethodBeat.i(99038);
        int itemViewType = getItemViewType(i2);
        Log.i("MicroMsg.SnsphotoAdapter", "position ".concat(String.valueOf(itemViewType)));
        if (itemViewType == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof e)) {
                eVar2 = new e();
                view = aa.jQ(this.dKq).inflate(R.layout.bwt, (ViewGroup) null);
                eVar2.EIi = (TextView) view.findViewById(R.id.hxj);
                eVar2.EIh = (TextView) view.findViewById(R.id.hyx);
                eVar2.EIj = (TextView) view.findViewById(R.id.i20);
                eVar2.EIv = (MaskImageView) view.findViewById(R.id.dx3);
                eVar2.EIw = (QFadeImageView) view.findViewById(R.id.ihk);
                eVar2.EIx = (MaskImageView) view.findViewById(R.id.dx4);
                eVar2.EIy = (MaskImageView) view.findViewById(R.id.dx5);
                eVar2.EIz = (MMNeat7extView) view.findViewById(R.id.bmr);
                eVar2.EIA = (TextView) view.findViewById(R.id.jod);
                eVar2.EIB = (TextView) view.findViewById(R.id.joe);
                eVar2.EIC = (TextView) view.findViewById(R.id.jof);
                eVar2.EID = (TextView) view.findViewById(R.id.dxd);
                eVar2.EIE = view.findViewById(R.id.bn0);
                eVar2.EIm = (TextView) view.findViewById(R.id.h2);
                eVar2.EIk = (LinearLayout) view.findViewById(R.id.ebw);
                eVar2.EIl = (ImageView) view.findViewById(R.id.er4);
                eVar2.EnO = (LinearLayout) view.findViewById(R.id.ed1);
                eVar2.EnP = view.findViewById(R.id.ebv);
                eVar2.EIw.setOnClickListener(this.EHP.EnF);
                eVar2.EIv.setOnClickListener(this.EHP.EnF);
                eVar2.EIx.setOnClickListener(this.EHP.EnG);
                eVar2.EIy.setOnClickListener(this.EHP.EnH);
                eVar2.EIv.setOnLongClickListener(this.EHP.EIP);
                eVar2.EIx.setOnLongClickListener(this.EHP.EIP);
                eVar2.EIy.setOnLongClickListener(this.EHP.EIP);
                eVar2.EIF = (TextView) view.findViewById(R.id.jj0);
                eVar2.EIG = (TextView) view.findViewById(R.id.jj1);
                eVar2.EIH = (TextView) view.findViewById(R.id.jj2);
                eVar2.EII = (TextView) view.findViewById(R.id.iw8);
                eVar2.EIJ = (TextView) view.findViewById(R.id.iw9);
                eVar2.EIK = (TextView) view.findViewById(R.id.iw_);
                eVar2.EIL = (MaskLinearLayout) view.findViewById(R.id.hyt);
                eVar2.EIL.b(eVar2.EIv);
                eVar2.EIn = (LinearLayout) view.findViewById(R.id.day);
                eVar2.EIo = (TextView) view.findViewById(R.id.hzb);
                eVar2.EIo.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(99022);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", e.k.Ozl);
                        com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        h.INSTANCE.a(14098, 8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99022);
                    }
                });
                view.setTag(eVar2);
            } else {
                eVar2 = (e) view.getTag();
            }
            aj.faL().ff(eVar2.EIv);
            aj.faL().ff(eVar2.EIx);
            aj.faL().ff(eVar2.EIy);
            int i10 = -1;
            if (this.Enw.get(Integer.valueOf(i2)) != null) {
                i10 = this.Enw.get(Integer.valueOf(i2)).intValue();
            }
            eVar2.init();
            eVar2.EIj.setTag(Integer.valueOf(i2));
            eVar2.EIL.settouchEnable(false);
            eVar2.EIL.setBackgroundResource(0);
            eVar2.EIL.setDescendantFocusability(131072);
            eVar2.EIL.setClickable(false);
            eVar2.EIv.settouchEnable(true);
            eVar2.EIv.setClickable(true);
            eVar2.EIv.setLongClickable(false);
            eVar2.EIx.setLongClickable(false);
            eVar2.EIy.setLongClickable(false);
            eVar2.EIL.setOnClickListener(null);
            eVar2.EIL.setOnLongClickListener(null);
            eVar2.EIL.setLongClickable(false);
            if (i10 >= this.Enz || i10 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.o(99038);
                return view;
            }
            if (i10 - 1 >= 0) {
                SnsInfo snsInfo = (SnsInfo) getItem(i10 - 1);
                i8 = snsInfo.getHead();
                an.aQ(snsInfo.getLocalPrivate(), this.dJM);
            } else {
                i8 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(i2)) != null) {
                i9 = this.Enx.get(Integer.valueOf(i2)).intValue();
            } else {
                i9 = 1;
            }
            SnsInfo snsInfo2 = (SnsInfo) getItem(i10);
            TimeLineObject timeLine = snsInfo2.getTimeLine();
            if ((this.dJM && i2 == 0) || i8 == -1 || snsInfo2.getHead() != i8) {
                if (aI(i2, snsInfo2.field_snsId)) {
                    a(eVar2.EIh, eVar2.EIi, (long) snsInfo2.getCreateTime());
                }
                if (timeLine.Location != null) {
                    if (Util.isNullOrNil(timeLine.Location.kHV)) {
                        str4 = timeLine.Location.kea;
                    } else {
                        str4 = timeLine.Location.kHV;
                    }
                    if (str4 != null && !str4.equals("")) {
                        eVar2.EIm.setText(str4);
                        eVar2.EIm.setVisibility(0);
                    }
                }
                eVar2.EnP.setVisibility(0);
            }
            if (this.EHX == 0 || snsInfo2.field_snsId != this.EHX) {
                eVar2.EIn.setVisibility(8);
            } else {
                eVar2.EIn.setVisibility(0);
            }
            eVar2.EIk.setVisibility(0);
            if (!this.dJM || i2 != 0 || (this.isSearchMode && (!this.isSearchMode || !this.EHY))) {
                a(eVar2.EIj, i8, snsInfo2.getHead());
                if (i9 > 0) {
                    a(i10, eVar2.EIv, eVar2.EIA, eVar2.EID, eVar2.EIF, eVar2.EII, 1, eVar2, i2);
                    com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo) getItem(i10));
                }
                if (i9 >= 2) {
                    a(i10 + 1, eVar2.EIx, eVar2.EIB, eVar2.EID, eVar2.EIG, eVar2.EIJ, 2, eVar2, i2);
                    com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo) getItem(i10 + 1));
                }
                if (i9 >= 3) {
                    a(i10 + 2, eVar2.EIy, eVar2.EIC, eVar2.EID, eVar2.EIH, eVar2.EIK, 3, eVar2, i2);
                    com.tencent.mm.plugin.sns.k.e.DUQ.N((SnsInfo) getItem(i10 + 2));
                }
                if (i9 == 1) {
                    SnsInfo snsInfo3 = (SnsInfo) getItem(i10);
                    if (!Util.isNullOrNil(snsInfo3.getTimeLine().ContentDesc) && snsInfo3.getTypeFlag() == 1) {
                        eVar2.EIL.setDescendantFocusability(393216);
                        eVar2.EIL.setClickable(true);
                        eVar2.EIv.setClickable(false);
                        eVar2.EIv.settouchEnable(false);
                        eVar2.EIL.setOnClickListener(this.EHP.EnF);
                        eVar2.EIL.settouchEnable(true);
                        int i11 = snsInfo2.localid;
                        g.a aVar = new g.a();
                        aVar.ecf = i11;
                        if (this.EHO.get(Integer.valueOf(i2)) != null) {
                            aVar.position = this.EHO.get(Integer.valueOf(i2)).intValue();
                        } else {
                            aVar.position = 0;
                        }
                        if (snsInfo3.isInValid() && snsInfo3.isDieItem()) {
                            eVar2.EIL.setOnLongClickListener(this.EHP.EIP);
                        }
                        eVar2.EIL.setTag(aVar);
                    }
                }
                view.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return view;
            }
            eVar2.EIw.setVisibility(0);
            eVar2.EIw.setContentDescription(this.dKq.getString(R.string.haz));
            eVar2.EIv.setVisibility(8);
            eVar2.EIz.aw(this.Eny == 1 ? this.dKq.getString(R.string.hc7) : "");
            eVar2.EIz.setVisibility(0);
            eVar2.EIE.setVisibility(0);
            eVar2.EID.setVisibility(8);
            aj.faL().d(eVar2.EIw, R.color.a9u, R.drawable.aw1, this.dKq.hashCode());
            g.a aVar2 = new g.a();
            aVar2.ecf = -1;
            aVar2.position = -1;
            eVar2.EIw.setTag(aVar2);
            AppMethodBeat.o(99038);
            return view;
        } else if (itemViewType == 2) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof f)) {
                f fVar2 = new f();
                view = aa.jQ(this.dKq).inflate(R.layout.bx9, (ViewGroup) null);
                fVar2.EIi = (TextView) view.findViewById(R.id.hxj);
                fVar2.EIh = (TextView) view.findViewById(R.id.hyx);
                fVar2.EIj = (TextView) view.findViewById(R.id.i20);
                fVar2.EIv = (MaskImageView) view.findViewById(R.id.dx3);
                fVar2.EIm = (TextView) view.findViewById(R.id.h2);
                fVar2.EIk = (LinearLayout) view.findViewById(R.id.ebw);
                fVar2.EIl = (ImageView) view.findViewById(R.id.er4);
                fVar2.EnO = (LinearLayout) view.findViewById(R.id.ed1);
                fVar2.EnP = view.findViewById(R.id.ebv);
                fVar2.EIv.setOnClickListener(this.EHP.EIO);
                fVar2.EIF = (TextView) view.findViewById(R.id.jj0);
                fVar2.EIL = (MaskLinearLayout) view.findViewById(R.id.hyt);
                fVar2.EIL.b(fVar2.EIv);
                fVar2.EIz = (MMNeat7extView) view.findViewById(R.id.bmr);
                fVar2.EIE = view.findViewById(R.id.bn0);
                fVar2.EIn = (LinearLayout) view.findViewById(R.id.day);
                fVar2.EIo = (TextView) view.findViewById(R.id.hzb);
                fVar2.EIo.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(99021);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", e.k.Ozl);
                        com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        h.INSTANCE.a(14098, 8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99021);
                    }
                });
                view.setTag(fVar2);
                fVar = fVar2;
            } else {
                fVar = (f) view.getTag();
            }
            aj.faL().ff(fVar.EIv);
            if (this.Enw.get(Integer.valueOf(i2)) != null) {
                i6 = this.Enw.get(Integer.valueOf(i2)).intValue();
            } else {
                i6 = -1;
            }
            fVar.init();
            fVar.EIj.setTag(Integer.valueOf(i2));
            fVar.EIL.settouchEnable(false);
            fVar.EIL.setBackgroundResource(0);
            fVar.EIL.setDescendantFocusability(131072);
            fVar.EIL.setClickable(false);
            fVar.EIv.settouchEnable(true);
            fVar.EIv.setClickable(true);
            fVar.EIL.setOnClickListener(null);
            if (i6 >= this.Enz || i6 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.o(99038);
                return view;
            }
            if (i6 - 1 >= 0) {
                SnsInfo snsInfo4 = (SnsInfo) getItem(i6 - 1);
                i7 = snsInfo4.getHead();
                an.aQ(snsInfo4.getLocalPrivate(), this.dJM);
            } else {
                i7 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(i2)) != null) {
                this.Enx.get(Integer.valueOf(i2)).intValue();
            }
            SnsInfo snsInfo5 = (SnsInfo) getItem(i6);
            TimeLineObject timeLine2 = snsInfo5.getTimeLine();
            if ((this.dJM && i2 == 0) || i7 == -1 || snsInfo5.getHead() != i7) {
                if (aI(i2, snsInfo5.field_snsId)) {
                    a(fVar.EIh, fVar.EIi, (long) snsInfo5.getCreateTime());
                }
                if (timeLine2.Location != null) {
                    if (Util.isNullOrNil(timeLine2.Location.kHV)) {
                        str3 = timeLine2.Location.kea;
                    } else {
                        str3 = timeLine2.Location.kHV;
                    }
                    if (str3 != null && !str3.equals("")) {
                        fVar.EIm.setText(str3);
                        fVar.EIm.setVisibility(0);
                    }
                }
                fVar.EnP.setVisibility(0);
            }
            a(fVar.EIj, i7, snsInfo5.getHead());
            if (this.EHX == 0 || snsInfo5.field_snsId != this.EHX) {
                fVar.EIn.setVisibility(8);
            } else {
                fVar.EIn.setVisibility(0);
            }
            fVar.EIk.setVisibility(0);
            bp bpVar = new bp(this.EHN.tag);
            bpVar.hXs = snsInfo5.field_createTime;
            fVar.EIv.setVisibility(0);
            aj.faL().a(timeLine2.ContentObj.LoV, fVar.EIv, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar);
            if (an.aQ(snsInfo5.getLocalPrivate(), this.dJM)) {
                fVar.EIF.setVisibility(0);
                fVar.EIF.setBackgroundResource(R.drawable.bkf);
                as Kn = this.EBg.Kn(snsInfo5.getUserName());
                if (Kn != null) {
                    Kn.arJ();
                }
            }
            SnsInfo snsInfo6 = (SnsInfo) getItem(i6);
            String str5 = snsInfo6.getTimeLine().ContentDesc;
            if (str5 != null && !str5.equals("")) {
                fVar.EIE.setVisibility(0);
                fVar.EIz.setVisibility(0);
                fVar.EIz.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, str5, fVar.EIz.getTextSize()));
            }
            fVar.EIL.setDescendantFocusability(393216);
            fVar.EIL.setClickable(true);
            fVar.EIv.setClickable(false);
            fVar.EIv.settouchEnable(false);
            fVar.EIL.setOnClickListener(this.EHP.EIO);
            fVar.EIL.settouchEnable(true);
            int i12 = snsInfo5.localid;
            g.a aVar3 = new g.a();
            aVar3.ecf = i12;
            if (this.EHO.get(Integer.valueOf(i2)) != null) {
                aVar3.position = this.EHO.get(Integer.valueOf(i2)).intValue();
            } else {
                aVar3.position = 0;
            }
            fVar.EIL.setTag(aVar3);
            view.setDrawingCacheEnabled(false);
            com.tencent.mm.plugin.sns.k.e.DUQ.N(snsInfo6);
            AppMethodBeat.o(99038);
            return view;
        } else if (itemViewType == 3) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                eVar = new e();
                view = aa.jQ(this.dKq).inflate(R.layout.bwt, (ViewGroup) null);
                eVar.EIi = (TextView) view.findViewById(R.id.hxj);
                eVar.EIh = (TextView) view.findViewById(R.id.hyx);
                eVar.EIj = (TextView) view.findViewById(R.id.i20);
                eVar.EIv = (MaskImageView) view.findViewById(R.id.dx3);
                eVar.EIw = (QFadeImageView) view.findViewById(R.id.ihk);
                eVar.EIx = (MaskImageView) view.findViewById(R.id.dx4);
                eVar.EIy = (MaskImageView) view.findViewById(R.id.dx5);
                eVar.EIz = (MMNeat7extView) view.findViewById(R.id.bmr);
                eVar.EIA = (TextView) view.findViewById(R.id.jod);
                eVar.EIB = (TextView) view.findViewById(R.id.joe);
                eVar.EIC = (TextView) view.findViewById(R.id.jof);
                eVar.EID = (TextView) view.findViewById(R.id.dxd);
                eVar.EIE = view.findViewById(R.id.bn0);
                eVar.EIm = (TextView) view.findViewById(R.id.h2);
                eVar.EIk = (LinearLayout) view.findViewById(R.id.ebw);
                eVar.EIl = (ImageView) view.findViewById(R.id.er4);
                eVar.EnO = (LinearLayout) view.findViewById(R.id.ed1);
                eVar.EnP = view.findViewById(R.id.ebv);
                eVar.EIw.setOnClickListener(this.EHP.EIN);
                eVar.EIv.setOnClickListener(this.EHP.EIN);
                eVar.EIF = (TextView) view.findViewById(R.id.jj0);
                eVar.EIG = (TextView) view.findViewById(R.id.jj1);
                eVar.EIH = (TextView) view.findViewById(R.id.jj2);
                eVar.EII = (TextView) view.findViewById(R.id.iw8);
                eVar.EIJ = (TextView) view.findViewById(R.id.iw9);
                eVar.EIK = (TextView) view.findViewById(R.id.iw_);
                eVar.EIL = (MaskLinearLayout) view.findViewById(R.id.hyt);
                eVar.EIL.b(eVar.EIv);
                eVar.EIn = (LinearLayout) view.findViewById(R.id.day);
                eVar.EIo = (TextView) view.findViewById(R.id.hzb);
                eVar.EIo.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(203629);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", e.k.Ozl);
                        com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        h.INSTANCE.a(14098, 8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203629);
                    }
                });
                view.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
            }
            aj.faL().ff(eVar.EIv);
            aj.faL().ff(eVar.EIx);
            aj.faL().ff(eVar.EIy);
            int i13 = -1;
            if (this.Enw.get(Integer.valueOf(i2)) != null) {
                i13 = this.Enw.get(Integer.valueOf(i2)).intValue();
            }
            eVar.init();
            eVar.EIj.setTag(Integer.valueOf(i2));
            eVar.EIL.settouchEnable(false);
            eVar.EIL.setBackgroundResource(0);
            eVar.EIL.setDescendantFocusability(131072);
            eVar.EIL.setClickable(false);
            eVar.EIv.settouchEnable(true);
            eVar.EIv.setClickable(true);
            eVar.EIL.setOnClickListener(null);
            if (i13 >= this.Enz || i13 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.o(99038);
                return view;
            }
            if (i13 - 1 >= 0) {
                SnsInfo snsInfo7 = (SnsInfo) getItem(i13 - 1);
                i5 = snsInfo7.getHead();
                an.aQ(snsInfo7.getLocalPrivate(), this.dJM);
            } else {
                i5 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            SnsInfo snsInfo8 = (SnsInfo) getItem(i13);
            TimeLineObject timeLine3 = snsInfo8.getTimeLine();
            if ((this.dJM && i2 == 0) || i5 == -1 || snsInfo8.getHead() != i5) {
                if (aI(i2, snsInfo8.field_snsId)) {
                    a(eVar.EIh, eVar.EIi, (long) snsInfo8.getCreateTime());
                }
                if (timeLine3.Location != null) {
                    if (Util.isNullOrNil(timeLine3.Location.kHV)) {
                        str2 = timeLine3.Location.kea;
                    } else {
                        str2 = timeLine3.Location.kHV;
                    }
                    if (str2 != null && !str2.equals("")) {
                        eVar.EIm.setText(str2);
                        eVar.EIm.setVisibility(0);
                    }
                }
                eVar.EnP.setVisibility(0);
            }
            a(eVar.EIj, i5, snsInfo8.getHead());
            if (this.EHX == 0 || snsInfo8.field_snsId != this.EHX) {
                eVar.EIn.setVisibility(8);
            } else {
                eVar.EIn.setVisibility(0);
            }
            eVar.EIk.setVisibility(0);
            if (!this.dJM || i2 != 0) {
                a(i13, eVar.EIv, eVar.EIA, eVar.EID, eVar.EIF, eVar.EII, 1, eVar, i2);
                SnsInfo snsInfo9 = (SnsInfo) getItem(i13);
                if (!Util.isNullOrNil(snsInfo9.getTimeLine().ContentDesc) && snsInfo9.getTypeFlag() == 1) {
                    eVar.EIL.setDescendantFocusability(393216);
                    eVar.EIL.setClickable(true);
                    eVar.EIv.setClickable(false);
                    eVar.EIv.settouchEnable(false);
                    eVar.EIL.setOnClickListener(this.EHP.EIN);
                    eVar.EIL.settouchEnable(true);
                    int i14 = snsInfo8.localid;
                    g.a aVar4 = new g.a();
                    aVar4.ecf = i14;
                    if (this.EHO.get(Integer.valueOf(i2)) != null) {
                        aVar4.position = this.EHO.get(Integer.valueOf(i2)).intValue();
                    } else {
                        aVar4.position = 0;
                    }
                    eVar.EIL.setTag(aVar4);
                }
                com.tencent.mm.plugin.sns.k.e.DUQ.N(snsInfo9);
                view.setDrawingCacheEnabled(false);
                AppMethodBeat.o(99038);
                return view;
            }
            eVar.EIw.setVisibility(0);
            eVar.EIw.setContentDescription(this.dKq.getString(R.string.haz));
            eVar.EIv.setVisibility(8);
            eVar.EIz.aw(this.Eny == 1 ? this.dKq.getString(R.string.hc7) : "");
            eVar.EIz.setVisibility(0);
            eVar.EIE.setVisibility(0);
            eVar.EID.setVisibility(8);
            aj.faL().d(eVar.EIw, R.color.a9u, R.drawable.aw1, this.dKq.hashCode());
            g.a aVar5 = new g.a();
            aVar5.ecf = -1;
            aVar5.position = -1;
            eVar.EIw.setTag(aVar5);
            AppMethodBeat.o(99038);
            return view;
        } else if (itemViewType == 4) {
            View n = n(i2, view);
            AppMethodBeat.o(99038);
            return n;
        } else if (itemViewType == 5) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                c cVar2 = new c();
                view = aa.jQ(this.dKq).inflate(R.layout.bwr, (ViewGroup) null);
                cVar2.EIg = view.findViewById(R.id.bf0);
                cVar2.EIi = (TextView) view.findViewById(R.id.hxj);
                cVar2.EIh = (TextView) view.findViewById(R.id.hyx);
                cVar2.EIj = (TextView) view.findViewById(R.id.i20);
                cVar2.EIm = (TextView) view.findViewById(R.id.h2);
                cVar2.EnP = view.findViewById(R.id.ebv);
                cVar2.EIm = (TextView) view.findViewById(R.id.h2);
                cVar2.EIk = (LinearLayout) view.findViewById(R.id.ebw);
                cVar2.EIl = (ImageView) view.findViewById(R.id.er4);
                cVar2.EnO = (LinearLayout) view.findViewById(R.id.ed1);
                cVar2.pIP = (MMNeat7extView) view.findViewById(R.id.bn6);
                cVar2.EIt = (TagImageView) view.findViewById(R.id.dw4);
                cVar2.uzC = (ImageView) view.findViewById(R.id.i4t);
                cVar2.titleTv = (TextView) view.findViewById(R.id.ir7);
                cVar2.EIr = (TextView) view.findViewById(R.id.h7r);
                cVar2.EIg.setOnClickListener(this.EHP.EIM);
                cVar2.EIs = view.findViewById(R.id.fbh);
                cVar2.EIu = (TextView) view.findViewById(R.id.bey);
                cVar2.EIn = (LinearLayout) view.findViewById(R.id.day);
                cVar2.EIo = (TextView) view.findViewById(R.id.hzb);
                cVar2.EIo.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.bh.AnonymousClass11 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(163121);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", e.k.Ozl);
                        com.tencent.mm.br.c.b(bh.this.dKq, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        h.INSTANCE.a(14098, 8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelfAdapter$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(163121);
                    }
                });
                view.setTag(cVar2);
                r.b(cVar2.EIt, this.dKq);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.EIj.setTag(Integer.valueOf(i2));
            if (this.Enw.get(Integer.valueOf(i2)) != null) {
                i3 = this.Enw.get(Integer.valueOf(i2)).intValue();
            } else {
                i3 = -1;
            }
            cVar.init();
            if (i3 >= this.Enz || i3 == -1) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                view.setVisibility(8);
                AppMethodBeat.o(99038);
                return view;
            }
            view.setVisibility(0);
            if (i3 - 1 >= 0) {
                SnsInfo snsInfo10 = (SnsInfo) getItem(i3 - 1);
                i4 = snsInfo10.getHead();
                an.aQ(snsInfo10.getLocalPrivate(), this.dJM);
            } else {
                i4 = -1;
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            SnsInfo snsInfo11 = (SnsInfo) getItem(i3);
            TimeLineObject timeLine4 = snsInfo11.getTimeLine();
            if ((this.dJM && i2 == 0) || i4 == -1 || snsInfo11.getHead() != i4) {
                if (aI(i2, snsInfo11.field_snsId)) {
                    a(cVar.EIh, cVar.EIi, (long) snsInfo11.getCreateTime());
                }
                if (timeLine4.Location != null) {
                    if (Util.isNullOrNil(timeLine4.Location.kHV)) {
                        str = timeLine4.Location.kea;
                    } else {
                        str = timeLine4.Location.kHV;
                    }
                    if (str != null && !str.equals("")) {
                        cVar.EIm.setText(str);
                        cVar.EIm.setVisibility(0);
                    }
                }
                cVar.EnP.setVisibility(0);
            }
            a(cVar.EIj, i4, snsInfo11.getHead());
            if (this.EHX == 0 || snsInfo11.field_snsId != this.EHX) {
                cVar.EIn.setVisibility(8);
            } else {
                cVar.EIn.setVisibility(0);
            }
            g.a aVar6 = new g.a();
            aVar6.ecf = snsInfo11.localid;
            if (this.EHO.get(Integer.valueOf(i2)) != null) {
                aVar6.position = this.EHO.get(Integer.valueOf(i2)).intValue();
            } else {
                aVar6.position = 0;
            }
            cVar.EIg.setTag(aVar6);
            if (!Util.isNullOrNil(timeLine4.ContentDesc)) {
                cVar.pIP.setVisibility(0);
                cVar.pIP.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, timeLine4.ContentDesc, cVar.pIP.getTextSize()));
            } else {
                cVar.pIP.setVisibility(8);
            }
            cVar.EIk.setVisibility(0);
            cVar.pIP.getWrappedTextView().setSingleLine(true);
            cVar.EIs.setVisibility(0);
            bp bpVar2 = new bp(this.EHN.tag);
            bpVar2.hXs = snsInfo11.field_createTime;
            if (timeLine4.ContentObj.Lpa == null) {
                Log.w("MicroMsg.SnsphotoAdapter", "finder share object or share topic is null!");
                AppMethodBeat.o(99038);
                return view;
            }
            cVar.titleTv.setTextColor(this.dKq.getResources().getColor(R.color.a2x));
            String str6 = "";
            if (timeLine4.ContentObj.Lpa != null) {
                cVar.EIt.setVisibility(0);
                String str7 = timeLine4.ContentObj.Lpa.title;
                cnb cnb = new cnb();
                cnb.Url = timeLine4.ContentObj.Lpa.iAo;
                cnb.Msz = timeLine4.ContentObj.Lpa.iAo;
                cnb.oUv = 2;
                cnb.MsA = 1;
                cnb.MsB = new cnd();
                cnb.Mcw = 1;
                cnb.MsB.Mto = (float) timeLine4.ContentObj.Lpa.width;
                cnb.MsB.Mtp = (float) timeLine4.ContentObj.Lpa.height;
                cnb.Id = snsInfo11.getSnsId();
                aj.faL().a(cnb, cVar.EIt, this.dKq.hashCode(), g.a.IMG_SCENE_SNSUSER, bpVar2);
                str6 = str7;
            }
            if (str6.length() > 40) {
                str6 = str6.substring(0, 40) + "...";
            }
            if (cVar.EIt != null) {
                cVar.EIt.setOnClickListener(null);
            }
            cVar.uzC.setVisibility(0);
            cVar.uzC.setImageDrawable(com.tencent.mm.ui.ar.m(cVar.uzC.getContext(), R.raw.icons_outlined_video_call, -1));
            cVar.EIr.setVisibility(8);
            if (!Util.isNullOrNil(str6)) {
                if (cVar.EIr.getVisibility() == 8) {
                    cVar.titleTv.setMaxLines(2);
                } else {
                    cVar.titleTv.setMaxLines(1);
                }
                cVar.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.dKq, str6));
                cVar.titleTv.setVisibility(0);
            } else {
                cVar.titleTv.setVisibility(8);
            }
            com.tencent.mm.plugin.sns.k.e.DUQ.N(snsInfo11);
            view.setDrawingCacheEnabled(false);
            AppMethodBeat.o(99038);
            return view;
        } else if (itemViewType == 6) {
            View l = l(i2, view);
            AppMethodBeat.o(99038);
            return l;
        } else {
            View m = m(i2, view);
            AppMethodBeat.o(99038);
            return m;
        }
    }

    public final void ffM() {
        AppMethodBeat.i(99048);
        vw(true);
        notifyDataSetChanged();
        AppMethodBeat.o(99048);
    }

    static /* synthetic */ void c(bh bhVar) {
        AppMethodBeat.i(99055);
        if (bhVar.EHW != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= bhVar.list.size()) {
                    i2 = 0;
                    break;
                }
                SnsInfo snsInfo = bhVar.list.get(i2);
                if (snsInfo.field_snsId <= bhVar.EHW) {
                    bhVar.EHX = snsInfo.field_snsId;
                    break;
                }
                i2++;
            }
            if (i2 == 0 && !bhVar.EHY) {
                bhVar.EHX = 0;
            }
        }
        AppMethodBeat.o(99055);
    }

    static /* synthetic */ void d(bh bhVar) {
        AppMethodBeat.i(99056);
        if (!(!bhVar.dJM || bhVar.list == null || an.DMh == 0)) {
            for (int i2 = 0; i2 < bhVar.list.size(); i2++) {
                SnsInfo snsInfo = bhVar.list.get(i2);
                if (snsInfo.field_snsId == an.DMh) {
                    if (i2 > 0) {
                        int head = snsInfo.getHead();
                        int head2 = bhVar.list.get(i2 - 1).getHead();
                        if (head == head2) {
                            an.DMi += at.fromDPToPix(bhVar.dKq, 27);
                        } else if (!(bm.getYear() == head / 10000 || head / 10000 == head2 / 10000)) {
                            an.DMi += (at.fromDPToPix(bhVar.dKq, -20) - at.fromDPToPix(bhVar.dKq, 10)) - bhVar.EHZ;
                        }
                        bhVar.EIa = i2;
                        AppMethodBeat.o(99056);
                        return;
                    } else {
                        bhVar.EIa = 0;
                        AppMethodBeat.o(99056);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(99056);
    }
}
