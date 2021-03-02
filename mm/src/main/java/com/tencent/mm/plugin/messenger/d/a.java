package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a implements e {
    private LinkedList<e.d> UYW = new LinkedList<>();
    private Map<String, LinkedList<e.b>> zqE = new HashMap();
    private Map<String, LinkedList<e.a>> zqF = new HashMap();
    private Map<String, HashSet<e.c>> zqG = new HashMap();
    private com.tencent.mm.av.a.d.a<Long, CharSequence> zqH = new com.tencent.mm.av.a.d.a<>(200);
    private com.tencent.mm.av.a.d.a<Long, CharSequence> zqI = new com.tencent.mm.av.a.d.a<>(500);
    public q zqJ = new q() {
        /* class com.tencent.mm.plugin.messenger.d.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(90750);
            Log.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", map.toString());
            a.a(a.this, str, map, aVar);
            AppMethodBeat.o(90750);
        }
    };

    public a() {
        AppMethodBeat.i(90754);
        AppMethodBeat.o(90754);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void a(final String str, final e.c cVar) {
        AppMethodBeat.i(194490);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.messenger.d.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(90751);
                Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", str);
                HashSet hashSet = (HashSet) a.this.zqG.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                if (!hashSet.contains(cVar)) {
                    hashSet.add(cVar);
                }
                a.this.zqG.put(str, hashSet);
                AppMethodBeat.o(90751);
            }
        });
        AppMethodBeat.o(194490);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void b(final String str, final e.c cVar) {
        AppMethodBeat.i(194491);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.messenger.d.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(90752);
                Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", str);
                HashSet hashSet = (HashSet) a.this.zqG.get(str);
                if (hashSet == null) {
                    AppMethodBeat.o(90752);
                    return;
                }
                hashSet.remove(cVar);
                if (hashSet.size() == 0) {
                    a.this.zqG.remove(str);
                    AppMethodBeat.o(90752);
                    return;
                }
                a.this.zqG.put(str, hashSet);
                AppMethodBeat.o(90752);
            }
        });
        AppMethodBeat.o(194491);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void a(String str, e.b bVar) {
        AppMethodBeat.i(194492);
        if (!this.zqE.containsKey(str)) {
            this.zqE.put(str, new LinkedList<>());
        }
        LinkedList<e.b> linkedList = this.zqE.get(str);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s list=%s", str, linkedList);
        if (linkedList != null && !linkedList.contains(bVar)) {
            this.zqE.get(str).add(bVar);
        }
        AppMethodBeat.o(194492);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void aDU(String str) {
        AppMethodBeat.i(194493);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", str);
        if (!this.zqE.containsKey(str)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList<e.b> linkedList = this.zqE.get(str);
        if (linkedList == null) {
            Log.e("MicroMsg.SysMsgTemplateImp", "list is null!");
            AppMethodBeat.o(194493);
            return;
        }
        Log.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.o(194493);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void a(String str, e.a aVar) {
        AppMethodBeat.i(90759);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", str);
        if (!this.zqF.containsKey(str)) {
            this.zqF.put(str, new LinkedList<>());
        }
        if (!this.zqF.get(str).contains(aVar)) {
            this.zqF.get(str).add(aVar);
        }
        AppMethodBeat.o(90759);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void aDV(String str) {
        AppMethodBeat.i(90760);
        Log.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", str);
        if (!this.zqF.containsKey(str)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList<e.a> linkedList = this.zqF.get(str);
        Log.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.o(90760);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final CharSequence b(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(194494);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            AppMethodBeat.o(194494);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            Log.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            AppMethodBeat.o(194494);
            return null;
        }
        String str2 = parseXml.get(".sysmsg.$type");
        if (Util.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", str2);
            AppMethodBeat.o(194494);
            return null;
        }
        CharSequence a2 = a(parseXml, bundle, weakReference, 0, weakReference2);
        AppMethodBeat.o(194494);
        return a2;
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final CharSequence aDW(String str) {
        AppMethodBeat.i(90762);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            AppMethodBeat.o(90762);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            Log.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            AppMethodBeat.o(90762);
            return null;
        }
        String str2 = parseXml.get(".sysmsg.$type");
        if (Util.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            Log.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", str2);
            AppMethodBeat.o(90762);
            return null;
        }
        CharSequence a2 = a(parseXml, null, null, 1, null);
        AppMethodBeat.o(90762);
        return a2;
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void a(String str, Map<String, String> map, Bundle bundle) {
        AppMethodBeat.i(194495);
        try {
            HashSet<e.c> hashSet = this.zqG.get(bundle.getString(MessengerShareContentUtility.TEMPLATE_TYPE));
            if (hashSet != null) {
                Iterator<e.c> it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next().b(str, map, bundle);
                }
            }
            AppMethodBeat.o(194495);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SysMsgTemplateImp", e2, "", new Object[0]);
            AppMethodBeat.o(194495);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void a(e.d dVar) {
        AppMethodBeat.i(259559);
        if (!this.UYW.contains(dVar)) {
            this.UYW.add(dVar);
        }
        AppMethodBeat.o(259559);
    }

    @Override // com.tencent.mm.plugin.messenger.a.e
    public final void b(e.d dVar) {
        AppMethodBeat.i(259560);
        this.UYW.remove(dVar);
        AppMethodBeat.o(259560);
    }

    private CharSequence a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i2, WeakReference<NeatTextView> weakReference2) {
        e.d dVar;
        AppMethodBeat.i(194496);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            String str = ".sysmsg.sysmsgtemplate.content_template" + new StringBuilder().append(i3 == 0 ? "" : Integer.valueOf(i3)).toString();
            if (map.get(str) == null) {
                break;
            }
            String str2 = map.get(str + ".$type");
            if (!aFb(str2)) {
                Log.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", str2);
                arrayList.add(G(str, map));
            }
            if (bundle != null) {
                bundle.putString(MessengerShareContentUtility.TEMPLATE_TYPE, str2);
            }
            String str3 = map.get(str + ".template");
            Log.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", str3);
            ArrayList<c.a> aFd = c.aFd(str3);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aFd == null ? 0 : aFd.size());
            Log.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", objArr);
            if (aFd == null || aFd.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator<c.a> it = aFd.iterator();
                while (it.hasNext()) {
                    c.a next = it.next();
                    if (next.type == 0) {
                        Iterator<e.d> it2 = this.UYW.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                dVar = null;
                                break;
                            }
                            dVar = it2.next();
                            if (dVar.cE(map).booleanValue()) {
                                break;
                            }
                        }
                        if (dVar != null) {
                            arrayList2.add(dVar.V(map, next.content));
                        } else {
                            arrayList2.add(new SpannableString(l.c(MMApplicationContext.getContext(), next.content)));
                        }
                    } else if (next.type == 1) {
                        int i4 = 0;
                        while (true) {
                            String str4 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
                            if (i4 != 0) {
                                str4 = str4 + i4;
                            }
                            if (map.get(str4) == null) {
                                break;
                            }
                            if (next.content.equals(map.get(str4 + ".$name"))) {
                                String str5 = map.get(str4 + ".$type");
                                if (i2 == 0) {
                                    LinkedList<e.b> linkedList = this.zqE.get(str5);
                                    e.b last = (linkedList == null || linkedList.size() <= 0) ? null : this.zqE.get(str5).getLast();
                                    if (!aFc(str5) || last == null) {
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = Util.nullAs(str5, "");
                                        objArr2[1] = Boolean.valueOf(last == null);
                                        Log.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", objArr2);
                                        arrayList2.add(G(str4, map));
                                    } else {
                                        CharSequence a2 = last.a(map, str4, bundle, weakReference, weakReference2);
                                        Q(a2);
                                        arrayList2.add(nullAsNil(a2));
                                    }
                                } else if (i2 == 1) {
                                    LinkedList<e.a> linkedList2 = this.zqF.get(str5);
                                    e.a last2 = (linkedList2 == null || linkedList2.size() <= 0) ? null : this.zqF.get(str5).getLast();
                                    if (!aFc(str5) || last2 == null) {
                                        arrayList2.add(G(str4, map));
                                    } else {
                                        arrayList2.add(Util.nullAsNil(last2.f(map, str4)));
                                    }
                                } else {
                                    Log.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i4++;
                        }
                    } else {
                        Log.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                CharSequence concactSpannable = concactSpannable(arrayList2);
                Log.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", concactSpannable);
                arrayList.add(concactSpannable);
            }
            i3++;
        }
        if (arrayList.size() == 0) {
            Log.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(194496);
            return spannableString;
        }
        CharSequence concactSpannable2 = concactSpannable(arrayList);
        AppMethodBeat.o(194496);
        return concactSpannable2;
    }

    private static CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.i(90764);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(90764);
            return spannableString;
        }
        AppMethodBeat.o(90764);
        return charSequence;
    }

    private static void Q(CharSequence charSequence) {
        ClickableSpan[] clickableSpanArr;
        AppMethodBeat.i(90765);
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned) && (clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class)) != null && clickableSpanArr.length > 0) {
            for (ClickableSpan clickableSpan : clickableSpanArr) {
                if (!(clickableSpan instanceof com.tencent.mm.ui.base.span.a)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                    AppMethodBeat.o(90765);
                    throw illegalArgumentException;
                }
            }
        }
        AppMethodBeat.o(90765);
    }

    private static CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.i(90766);
        CharSequence spannableString = new SpannableString("");
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            spannableString = TextUtils.concat(spannableString, it.next());
        }
        AppMethodBeat.o(90766);
        return spannableString;
    }

    private static CharSequence G(String str, Map<String, String> map) {
        AppMethodBeat.i(90767);
        if (Util.getInt(map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1) {
            Log.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(90767);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(l.c(MMApplicationContext.getContext(), Util.nullAsNil(map.get(str + ".plain"))));
        AppMethodBeat.o(90767);
        return spannableString2;
    }

    private static boolean aFb(String str) {
        AppMethodBeat.i(90768);
        if ("tmpl_type_profile".equals(str) || "tmpl_type_profilewithrevoke".equals(str) || "tmpl_type_profilewithrevokeqrcode".equals(str) || "tmpl_type_wxappnotifywithview".equals(str) || "tmpl_type_succeed_contact".equals(str) || "tmpl_type_jump_chat".equals(str) || "tmpl_type_gamelife_link_url".equals(str) || "tmpl_type_gamelife_plain".equals(str) || "new_tmpl_type_succeed_contact".equals(str) || "tmpl_type_profilewithrevokeandunbindapp".equals(str)) {
            AppMethodBeat.o(90768);
            return true;
        }
        AppMethodBeat.o(90768);
        return false;
    }

    private static boolean aFc(String str) {
        AppMethodBeat.i(90769);
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str) || "link_succeed_contact".equals(str) || "link_jump_chat".equals(str) || "link_admin_explain".equals(str) || "new_link_succeed_contact".equals(str) || "link_live".equals(str) || "link_url".equals(str) || "comment_link_profile".equals(str) || "link_revoke_unbindapp".equals(str) || "link_history".equals(str)) {
            AppMethodBeat.o(90769);
            return true;
        }
        AppMethodBeat.o(90769);
        return false;
    }

    static /* synthetic */ boolean a(a aVar, final String str, final Map map, final h.a aVar2) {
        AppMethodBeat.i(90770);
        if (aVar2 == null || aVar2.heO == null) {
            Log.e("MicroMsg.SysMsgTemplateImp", "hy: addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            AppMethodBeat.o(90770);
            return false;
        }
        de deVar = aVar2.heO;
        String a2 = z.a(deVar.KHn);
        String a3 = z.a(deVar.KHl);
        ca aJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(a3, deVar.Brn);
        boolean z = false;
        if (aJ.field_msgId > 0) {
            z = true;
        }
        aJ.yF(deVar.Brn);
        if (!aVar2.iLV || !aVar2.iLX) {
            aJ.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
        }
        aJ.setType(570425393);
        aJ.setContent(a2);
        aJ.nv(0);
        aJ.Cy(a3);
        aJ.BB(deVar.KHq);
        bp.a(aJ, aVar2);
        if (!z) {
            bp.x(aJ);
        } else {
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().b(deVar.Brn, aJ);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.messenger.d.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(90753);
                a.a(a.this, map, aVar2);
                AppMethodBeat.o(90753);
            }
        });
        AppMethodBeat.o(90770);
        return true;
    }

    static /* synthetic */ void a(a aVar, Map map, h.a aVar2) {
        AppMethodBeat.i(194497);
        int i2 = 0;
        while (true) {
            try {
                String str = (String) map.get((".sysmsg.sysmsgtemplate.content_template" + new StringBuilder().append(i2 == 0 ? "" : Integer.valueOf(i2)).toString()) + ".$type");
                if (!Util.isNullOrNil(str)) {
                    HashSet<e.c> hashSet = aVar.zqG.get(str);
                    if (hashSet != null) {
                        Iterator<e.c> it = hashSet.iterator();
                        while (it.hasNext()) {
                            it.next().a(map, aVar2);
                        }
                    }
                    i2++;
                } else {
                    AppMethodBeat.o(194497);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SysMsgTemplateImp", e2, "", new Object[0]);
                AppMethodBeat.o(194497);
                return;
            }
        }
    }
}
