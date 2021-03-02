package com.tencent.mm.plugin.sns.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements i, e {
    public static final Pattern DRc = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern DRd = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    private com.tencent.mm.plugin.sns.j.c DIP;
    public final int DQU = 500;
    private List<d> DQV;
    public ListView DQW;
    public bk DQX;
    public Map<Long, Integer> DQY = new HashMap();
    public HashSet<Long> DQZ = new HashSet<>();
    public final int DQr = 14;
    public HashSet<Long> DRa = new HashSet<>();
    private HashMap<Long, a> DRb = new HashMap<>();
    private q.a DRe = new q.a() {
        /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass6 */

        @Override // com.tencent.mm.pluginsdk.ui.span.q.a
        public final void b(View view, Object obj) {
        }
    };

    public c() {
        AppMethodBeat.i(96111);
        AppMethodBeat.o(96111);
    }

    static /* synthetic */ void a(c cVar, Context context, SnsObject snsObject, d.a aVar, d.b bVar, BaseTimeLineItem.BaseViewHolder baseViewHolder, d dVar) {
        AppMethodBeat.i(96127);
        cVar.a(context, snsObject, aVar, bVar, baseViewHolder, dVar);
        AppMethodBeat.o(96127);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(96112);
        Log.i("MicroMsg.SnSABTestMgr", "onSceneend " + i2 + " errCode " + i3);
        EventCenter.instance.publish(new oa());
        AppMethodBeat.o(96112);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        d DRo;
        int DRp = 0;
        int DRq = 0;
        String DRr = "";
        String DRs = "";
        long Dyz;
        String Dzk;
        long mEndTime = -1;
        long mStartTime = -1;

        public a(long j2, long j3, String str, d dVar) {
            this.DRo = dVar;
            this.mStartTime = j2;
            this.Dyz = j3;
            this.Dzk = str;
        }

        public final void iw(int i2, int i3) {
            this.DRp = i2;
            this.DRq = i3;
        }

        public final void K(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(96109);
            if (i2 == -1 || i3 == -1) {
                AppMethodBeat.o(96109);
                return;
            }
            String str = i2 + ":" + i3 + ":" + i4 + ":" + i5;
            String str2 = i2 + ":" + i3;
            if (str.equals(this.DRr) || (this.DRr.startsWith(str2) && i4 == 0 && i5 == 0)) {
                AppMethodBeat.o(96109);
                return;
            }
            this.DRr = str;
            addAction(i2 + ":" + i3 + ":" + i4 + ":" + i5);
            AppMethodBeat.o(96109);
        }

        private void addAction(String str) {
            AppMethodBeat.i(96110);
            if (!Util.isNullOrNil(this.DRs)) {
                this.DRs += "|";
            }
            this.DRs += str;
            AppMethodBeat.o(96110);
        }
    }

    private void Jy(long j2) {
        AppMethodBeat.i(96113);
        if (this.DIP == null) {
            this.DIP = new com.tencent.mm.plugin.sns.j.c();
        }
        if (this.DIP.DRK.size() > 500) {
            this.DIP.DRK.remove(0);
        }
        this.DIP.DRK.add(Long.valueOf(j2));
        AppMethodBeat.o(96113);
    }

    public final void clean() {
        AppMethodBeat.i(96114);
        this.DQW = null;
        this.DQX = null;
        if (this.DQZ != null) {
            Iterator<Long> it = this.DQZ.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                s sVar = new s(next.longValue(), 0, 0, (String) null);
                g.aAi();
                g.aAg().hqi.a(sVar, 0);
                Log.i("MicroMsg.SnSABTestMgr", "report id ".concat(String.valueOf(next)));
            }
        }
        if (this.DRb != null) {
            for (a aVar : this.DRb.values()) {
                a(aVar);
            }
            this.DRb.clear();
        }
        if (this.DQV.size() == 0 || this.DIP == null) {
            AppMethodBeat.o(96114);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().cachePath).append("ws_1100004").toString();
        Log.i("MicroMsg.SnSABTestMgr", "listToFile to list  ".concat(String.valueOf(sb2)));
        try {
            byte[] byteArray = this.DIP.toByteArray();
            com.tencent.mm.vfs.s.f(sb2, byteArray, byteArray.length);
            Log.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.DIP.DRK.size());
            AppMethodBeat.o(96114);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "listToFile failed: ".concat(String.valueOf(sb2)), new Object[0]);
            AppMethodBeat.o(96114);
        }
    }

    public static void c(View view, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(96115);
        baseViewHolder.EXh = false;
        baseViewHolder.EXg = (ViewStub) view.findViewById(R.id.hzw);
        baseViewHolder.EXg.setVisibility(8);
        baseViewHolder.EXl = (ViewStub) view.findViewById(R.id.hyb);
        baseViewHolder.EXl.setVisibility(8);
        AppMethodBeat.o(96115);
    }

    public final void a(final Context context, SnsObject snsObject, final BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        int i2;
        AppMethodBeat.i(96116);
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            f(baseViewHolder);
            AppMethodBeat.o(96116);
        } else if (this.DQV == null || this.DQV.size() == 0) {
            f(baseViewHolder);
            AppMethodBeat.o(96116);
        } else if (this.DRa.contains(Long.valueOf(snsObject.Id))) {
            f(baseViewHolder);
            baseViewHolder.EXw.setVisibility(8);
            baseViewHolder.EWw.setVisibility(8);
            baseViewHolder.convertView.setVisibility(8);
            AppMethodBeat.o(96116);
        } else if (snsObject.Username == null || snsObject.Username.equals(aj.fau())) {
            f(baseViewHolder);
            AppMethodBeat.o(96116);
        } else if (this.DIP == null || !this.DIP.DRK.contains(Long.valueOf(snsObject.Id))) {
            if (snsObject != null) {
                try {
                    byte[] a2 = z.a(snsObject.ObjectOperations);
                    i2 = Util.isNullOrNil(a2) ? 0 : ((eaj) new eaj().parseFrom(a2)).MZH;
                } catch (Exception e2) {
                    i2 = 0;
                }
            } else {
                i2 = 0;
            }
            int i3 = 0;
            if (!this.DQY.containsKey(Long.valueOf(snsObject.Id)) || (i3 = this.DQY.get(Long.valueOf(snsObject.Id)).intValue()) != -1) {
                final d dVar = null;
                Iterator<d> it = this.DQV.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null) {
                        if (next.DRt == i2) {
                            dVar = next;
                            break;
                        }
                    } else {
                        f(baseViewHolder);
                        AppMethodBeat.o(96116);
                        return;
                    }
                }
                if (dVar == null) {
                    f(baseViewHolder);
                    AppMethodBeat.o(96116);
                } else if (i3 >= dVar.DRu.size()) {
                    f(baseViewHolder);
                    AppMethodBeat.o(96116);
                } else {
                    final d.b bVar = dVar.DRu.get(i3);
                    int i4 = bVar.dDG;
                    f(baseViewHolder);
                    if (i2 > 0) {
                        if (!this.DRb.containsKey(Long.valueOf(snsObject.Id))) {
                            a aVar = new a(System.currentTimeMillis(), snsObject.Id, r.Jb(snsObject.Id), dVar);
                            aVar.iw(i4, bVar.lgB.size());
                            this.DRb.put(Long.valueOf(snsObject.Id), aVar);
                        } else {
                            this.DRb.get(Long.valueOf(snsObject.Id)).iw(i4, bVar.lgB.size());
                        }
                        if (i4 == 1) {
                            String str = bVar.title;
                            if (!baseViewHolder.EXh) {
                                baseViewHolder.EXi = baseViewHolder.EXg.inflate();
                                baseViewHolder.EXh = true;
                                baseViewHolder.EXk = (TextView) baseViewHolder.EXi.findViewById(R.id.gex);
                                baseViewHolder.EXj = (LinearLayout) baseViewHolder.EXi.findViewById(R.id.b5);
                            }
                            baseViewHolder.EXi.setVisibility(0);
                            baseViewHolder.EXk.setText(str);
                            List<d.a> list = bVar.lgB;
                            if (list.size() != baseViewHolder.EXj.getChildCount()) {
                                baseViewHolder.EXj.removeAllViews();
                                for (int i5 = 0; i5 < list.size(); i5++) {
                                    TextView textView = new TextView(baseViewHolder.EXj.getContext());
                                    textView.setText(list.get(i5).DRv);
                                    textView.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(context, 10), 0);
                                    textView.setVisibility(0);
                                    textView.setTextSize(1, 14.0f * com.tencent.mm.cb.a.ez(context));
                                    textView.setTextColor(context.getResources().getColor(R.color.a92));
                                    baseViewHolder.EXj.addView(textView);
                                }
                            }
                            for (int i6 = 0; i6 < list.size(); i6++) {
                                final d.a aVar2 = list.get(i6);
                                TextView textView2 = (TextView) baseViewHolder.EXj.getChildAt(i6);
                                textView2.setText(a(context, textView2, a(f.a(aVar2), snsObject), snsObject, baseViewHolder, aVar2, bVar, dVar));
                                textView2.setTag(snsObject);
                                textView2.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(96104);
                                        b bVar = new b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        c.a(c.this, context, view, aVar2, bVar, baseViewHolder, dVar);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(96104);
                                    }
                                });
                            }
                            AppMethodBeat.o(96116);
                            return;
                        } else if (i4 == 4) {
                            a(context, snsObject, baseViewHolder, bVar, dVar);
                            AppMethodBeat.o(96116);
                            return;
                        } else if (i4 == 2) {
                            if (b(context, snsObject, baseViewHolder, bVar, dVar)) {
                                AppMethodBeat.o(96116);
                                return;
                            } else {
                                AppMethodBeat.o(96116);
                                return;
                            }
                        }
                    }
                    f(baseViewHolder);
                    AppMethodBeat.o(96116);
                }
            } else {
                f(baseViewHolder);
                AppMethodBeat.o(96116);
            }
        } else {
            f(baseViewHolder);
            AppMethodBeat.o(96116);
        }
    }

    private boolean b(final Context context, final SnsObject snsObject, final BaseTimeLineItem.BaseViewHolder baseViewHolder, final d.b bVar, final d dVar) {
        AppMethodBeat.i(96118);
        if (bVar.lgB.size() == 2) {
            final d.a aVar = bVar.lgB.get(0);
            final d.a aVar2 = bVar.lgB.get(1);
            h.c(context, a(bVar.title, snsObject), context.getString(R.string.zb), a(f.a(aVar), snsObject), a(f.a(aVar2), snsObject), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(96106);
                    Log.i("MicroMsg.SnSABTestMgr", "onClick alert1");
                    c.a(c.this, context, snsObject, aVar, bVar, baseViewHolder, dVar);
                    AppMethodBeat.o(96106);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(96107);
                    Log.i("MicroMsg.SnSABTestMgr", "onClick alert2");
                    c.a(c.this, context, snsObject, aVar2, bVar, baseViewHolder, dVar);
                    AppMethodBeat.o(96107);
                }
            });
            AppMethodBeat.o(96118);
            return true;
        }
        AppMethodBeat.o(96118);
        return false;
    }

    private void e(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(202799);
        if (baseViewHolder == null) {
            AppMethodBeat.o(202799);
            return;
        }
        Context context = baseViewHolder.convertView.getContext();
        if (context == null) {
            AppMethodBeat.o(202799);
            return;
        }
        if (baseViewHolder.convertView.getBackground() == null) {
            baseViewHolder.convertView.setBackgroundResource(R.drawable.qa);
            baseViewHolder.convertView.setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 8));
        }
        int i2 = baseViewHolder.position - 1;
        if (this.DQX != null) {
            WeakReference<View> weakReference = this.DQX.EKn.get(Integer.valueOf(i2));
            if (weakReference == null || weakReference.get() == null) {
                AppMethodBeat.o(202799);
                return;
            } else {
                weakReference.get().setBackgroundResource(R.drawable.qa);
                weakReference.get().setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 12), com.tencent.mm.cb.a.fromDPToPix(context, 8));
            }
        }
        AppMethodBeat.o(202799);
    }

    private void a(Context context, SnsObject snsObject, d.a aVar, d.b bVar, BaseTimeLineItem.BaseViewHolder baseViewHolder, d dVar) {
        AppMethodBeat.i(96120);
        Log.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + snsObject.Username + " " + snsObject.Id);
        int i2 = aVar.DRx - 1;
        a aVar2 = this.DRb.get(Long.valueOf(snsObject.Id));
        if (aVar2 != null) {
            aVar2.K(bVar.dDG, bVar.lgB.size(), aVar.index, aVar.actionType);
            aVar2.DRp = -1;
            aVar2.DRq = -1;
        }
        if (aVar.actionType == 3) {
            this.DQZ.add(Long.valueOf(snsObject.Id));
            this.DQY.put(Long.valueOf(snsObject.Id), Integer.valueOf(i2));
        } else if (aVar.actionType == 1) {
            this.DQY.put(Long.valueOf(snsObject.Id), Integer.valueOf(i2));
            Jy(snsObject.Id);
            f(baseViewHolder);
        } else if (aVar.actionType == 5) {
            if (this.DQZ.contains(Long.valueOf(snsObject.Id))) {
                this.DQZ.remove(Long.valueOf(snsObject.Id));
                Jy(snsObject.Id);
                f(baseViewHolder);
                if (this.DRb.containsKey(Long.valueOf(snsObject.Id))) {
                    a(this.DRb.remove(Long.valueOf(snsObject.Id)));
                }
            }
            this.DQY.put(Long.valueOf(snsObject.Id), -1);
            e(baseViewHolder);
            AppMethodBeat.o(96120);
            return;
        } else if (aVar.actionType == 7) {
            if (i2 < dVar.DRu.size()) {
                d.b bVar2 = dVar.DRu.get(i2);
                if (bVar2.dDG == 2) {
                    b(context, snsObject, baseViewHolder, bVar2, dVar);
                    AppMethodBeat.o(96120);
                    return;
                } else if (bVar2.dDG == 5) {
                    u.makeText(context, Util.nullAs(bVar2.title, ""), 0).show();
                    Jy(snsObject.Id);
                    f(baseViewHolder);
                    AppMethodBeat.o(96120);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            u.makeText(context, Util.nullAs(context.getString(R.string.h2v), ""), 0).show();
            this.DRa.add(Long.valueOf(snsObject.Id));
            f(baseViewHolder);
            EventCenter.instance.publish(new ob());
            e(baseViewHolder);
            AppMethodBeat.o(96120);
            return;
        } else if (aVar.actionType == 2) {
            String str = aVar.jumpUrl;
            Log.i("MicroMsg.SnSABTestMgr", "jump url ".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.jRt.i(intent, context);
            Jy(snsObject.Id);
            f(baseViewHolder);
            e(baseViewHolder);
            AppMethodBeat.o(96120);
            return;
        } else if (aVar.actionType == 8) {
            AppMethodBeat.o(96120);
            return;
        } else if (aVar.actionType == 4) {
            String str2 = snsObject.Username;
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            x xVar = new x(1, 5, "", linkedList.size(), linkedList, 0);
            g.aAi();
            g.aAg().hqi.a(xVar, 0);
        }
        if (i2 == 4 || i2 == 1) {
            a(context, snsObject, baseViewHolder);
        }
        AppMethodBeat.o(96120);
    }

    private static void f(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(96121);
        if (baseViewHolder == null) {
            AppMethodBeat.o(96121);
            return;
        }
        if (baseViewHolder.EXg != null) {
            baseViewHolder.EXg.setVisibility(8);
        }
        if (baseViewHolder.EXi != null) {
            baseViewHolder.EXi.setVisibility(8);
        }
        if (baseViewHolder.EXl != null) {
            baseViewHolder.EXl.setVisibility(8);
        }
        if (baseViewHolder.EXn != null) {
            baseViewHolder.EXn.setVisibility(8);
        }
        if (baseViewHolder.EXw.getVisibility() == 8) {
            baseViewHolder.EXw.setVisibility(0);
        }
        if (baseViewHolder.EWw.getVisibility() == 8) {
            baseViewHolder.EWw.setVisibility(0);
        }
        if (baseViewHolder.convertView.getVisibility() == 8) {
            baseViewHolder.convertView.setVisibility(0);
        }
        AppMethodBeat.o(96121);
    }

    static {
        AppMethodBeat.i(96128);
        AppMethodBeat.o(96128);
    }

    private static String a(String str, SnsObject snsObject) {
        Exception e2;
        String str2;
        boolean z;
        String group;
        AppMethodBeat.i(96122);
        try {
            if (Util.isNullOrNil(str)) {
                str2 = "";
                AppMethodBeat.o(96122);
            } else {
                String str3 = snsObject.Username;
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(str3);
                if (str.contains("{username}")) {
                    str = str.replace("{username}", Kn.arJ());
                }
                if (Kn.fuA == 1) {
                    z = false;
                } else if (Kn.fuA == 2) {
                    z = true;
                } else {
                    z = true;
                }
                while (true) {
                    try {
                        str2 = str;
                        Matcher matcher = DRd.matcher(str2);
                        if (!matcher.find() || matcher.groupCount() != 3) {
                            AppMethodBeat.o(96122);
                        } else {
                            String group2 = matcher.group();
                            if (!z) {
                                group = matcher.group(1);
                            } else {
                                group = z ? matcher.group(2) : matcher.group(3);
                            }
                            str = str2.replace(group2, group);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "settext error ", new Object[0]);
                        AppMethodBeat.o(96122);
                        return str2;
                    }
                }
                AppMethodBeat.o(96122);
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = str;
            Log.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "settext error ", new Object[0]);
            AppMethodBeat.o(96122);
            return str2;
        }
        return str2;
    }

    private SpannableString a(final Context context, TextView textView, String str, final SnsObject snsObject, final BaseTimeLineItem.BaseViewHolder baseViewHolder, final d.a aVar, final d.b bVar, final d dVar) {
        AppMethodBeat.i(96123);
        Matcher matcher = DRc.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, str);
            AppMethodBeat.o(96123);
            return c2;
        }
        String group = matcher.group();
        String group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        String replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new af());
        spannableString.setSpan(new q(snsObject.Username, new q.a() {
            /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.span.q.a
            public final void b(View view, Object obj) {
                AppMethodBeat.i(96108);
                c.a(c.this, context, snsObject, aVar, bVar, baseViewHolder, dVar);
                AppMethodBeat.o(96108);
            }
        }), indexOf, group2.length() + indexOf, 33);
        AppMethodBeat.o(96123);
        return spannableString;
    }

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z, bq bqVar) {
    }

    @Override // com.tencent.mm.plugin.sns.model.e
    public final void a(int i2, String str, long j2, TimeLineObject timeLineObject, boolean z) {
        AppMethodBeat.i(96124);
        if (this.DRb.containsKey(Long.valueOf(j2))) {
            a aVar = this.DRb.get(Long.valueOf(j2));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.K(aVar.DRp, aVar.DRq, 0, 0);
        }
        AppMethodBeat.o(96124);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(96125);
        d dVar = aVar.DRo;
        if (dVar == null) {
            AppMethodBeat.o(96125);
            return;
        }
        String str = dVar.DQT;
        String str2 = dVar.DQS;
        String str3 = aVar.Dzk;
        aVar.K(aVar.DRp, aVar.DRq, 0, 0);
        String str4 = aVar.DRs;
        if (Util.isNullOrNil(str4)) {
            str4 = aVar.DRp + ":" + aVar.DRq + ":0:0";
        }
        long j2 = aVar.mStartTime / 1000;
        if (aVar.mEndTime == -1) {
            aVar.mEndTime = System.currentTimeMillis();
        }
        long j3 = aVar.mEndTime / 1000;
        if (aVar != null) {
            Log.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j2 + " timelineId: " + str3);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11917, str, str2, "", "", 1, str3, str4, Long.valueOf(j2), Long.valueOf(j3));
        }
        AppMethodBeat.o(96125);
    }

    public final void init() {
        AppMethodBeat.i(179118);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.model.c.d.aXu().biC("10001").values()) {
            d dVar = new d();
            if (cVar == null) {
                Log.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (!cVar.isValid()) {
                Log.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            } else {
                Map<String, String> gzz = cVar.gzz();
                if (gzz != null) {
                    Log.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.f(cVar.field_layerId, cVar.field_expId, gzz);
                    if (dVar.dGX && dVar.DRu != null && dVar.DRu.size() > 0) {
                        arrayList.add(dVar);
                    }
                }
            }
        }
        this.DQV = arrayList;
        this.DQY.clear();
        this.DQZ.clear();
        this.DRb.clear();
        this.DIP = null;
        if (this.DQV == null || this.DQV.size() == 0) {
            AppMethodBeat.o(179118);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().cachePath).append("ws_1100004").toString();
        Log.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(sb2)));
        byte[] aW = com.tencent.mm.vfs.s.aW(sb2, 0, -1);
        if (aW != null) {
            try {
                this.DIP = (com.tencent.mm.plugin.sns.j.c) new com.tencent.mm.plugin.sns.j.c().parseFrom(aW);
                Log.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.DIP == null) {
                    Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    AppMethodBeat.o(179118);
                    return;
                }
                Log.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.DIP.DRK.size());
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "", new Object[0]);
                com.tencent.mm.vfs.s.deleteFile(sb2);
                AppMethodBeat.o(179118);
                return;
            }
        }
        AppMethodBeat.o(179118);
    }

    private boolean a(final Context context, SnsObject snsObject, final BaseTimeLineItem.BaseViewHolder baseViewHolder, final d.b bVar, final d dVar) {
        WeakReference<View> weakReference;
        AppMethodBeat.i(96117);
        baseViewHolder.convertView.setBackgroundDrawable(null);
        int i2 = baseViewHolder.position - 1;
        if (!(this.DQX == null || (weakReference = this.DQX.EKn.get(Integer.valueOf(i2))) == null || weakReference.get() == null)) {
            weakReference.get().setBackgroundDrawable(null);
        }
        if (!baseViewHolder.EXm) {
            baseViewHolder.EXn = baseViewHolder.EXl.inflate();
            baseViewHolder.EXm = true;
            baseViewHolder.EXo = (LinearLayout) baseViewHolder.EXn.findViewById(R.id.hty);
        }
        baseViewHolder.EXn.setVisibility(0);
        baseViewHolder.EXw.setVisibility(8);
        baseViewHolder.EWw.setVisibility(8);
        List<d.a> list = bVar.lgB;
        if (list.size() != baseViewHolder.EXo.getChildCount()) {
            baseViewHolder.EXo.removeAllViews();
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 10);
            for (int i3 = 0; i3 < list.size(); i3++) {
                TextView textView = new TextView(context);
                textView.setBackgroundResource(R.drawable.css);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.cb.a.ez(context));
                textView.setTextColor(context.getResources().getColor(R.color.a2x));
                baseViewHolder.EXo.addView(textView);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            final d.a aVar = list.get(i4);
            TextView textView2 = (TextView) baseViewHolder.EXo.getChildAt(i4);
            textView2.setText(aVar.DRv);
            textView2.setTag(snsObject);
            String a2 = a(f.a(aVar), snsObject);
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.h.c.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(96105);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c.a(c.this, context, view, aVar, bVar, baseViewHolder, dVar);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/newabtest/SnSABTestMgr$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96105);
                }
            });
            textView2.setText(a(context, textView2, a2, snsObject, baseViewHolder, aVar, bVar, dVar), TextView.BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.raw.album_abtesti_icon2), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        AppMethodBeat.o(96117);
        return true;
    }

    static /* synthetic */ void a(c cVar, Context context, View view, d.a aVar, d.b bVar, BaseTimeLineItem.BaseViewHolder baseViewHolder, d dVar) {
        AppMethodBeat.i(96126);
        Log.i("MicroMsg.SnSABTestMgr", "processButtonClick");
        if (view.getTag() instanceof SnsObject) {
            cVar.a(context, (SnsObject) view.getTag(), aVar, bVar, baseViewHolder, dVar);
        }
        AppMethodBeat.o(96126);
    }
}
