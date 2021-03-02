package com.tencent.mm.plugin.selectrecord.e;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Pair;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.ib;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends com.tencent.mm.plugin.messenger.d.b implements a {
    private static final Map<String, Pair<Long, String>> CXi = new ConcurrentHashMap();
    private static g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.selectrecord.e.b.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(187928);
            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(187928);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(187929);
            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(187929);
            return null;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(187930);
            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", str, Integer.valueOf(i2), dVar);
            if (dVar != null) {
                try {
                    if (dVar.field_retCode == 0) {
                        Pair pair = (Pair) b.CXi.get(str);
                        if (pair == null) {
                            Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, pair is null??");
                        } else {
                            String str2 = new String(s.aW((String) pair.second, 0, -1));
                            String II = b.II(((Long) pair.first).longValue());
                            if (s.YS(II)) {
                                s.deleteFile(II);
                            }
                            Log.d("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", pair.first, pair.second, Util.secPrint(str2), Long.valueOf(s.nw((String) pair.second, II)), Boolean.valueOf(s.deleteFile((String) pair.second)));
                            a aVar = (a) b.oPn.get(pair.first);
                            if (aVar != null) {
                                aVar.I(((Long) pair.first).longValue(), str2);
                            }
                        }
                        AppMethodBeat.o(187930);
                        return 0;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "callback %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
            if (cVar != null) {
                Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn process: %f", Double.valueOf(((double) cVar.field_finishedLength) / ((double) cVar.field_toltalLength)));
            }
            AppMethodBeat.o(187930);
            return 0;
        }
    };
    private static final Map<Long, a> oPn = new ConcurrentHashMap();
    private String CXg;
    private String CXh;
    private long dTS;
    private ProgressDialog gtM = null;
    private boolean isLoading = false;
    private WeakReference<Context> nhy;
    private String talker;

    static {
        AppMethodBeat.i(187943);
        AppMethodBeat.o(187943);
    }

    public b(b.AbstractC1472b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final String eiT() {
        return "link_history";
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final void release() {
        AppMethodBeat.i(187934);
        super.release();
        AppMethodBeat.o(187934);
    }

    @Override // com.tencent.mm.plugin.messenger.d.b
    public final CharSequence b(final Map<String, String> map, final String str, final Bundle bundle, final WeakReference<Context> weakReference, final WeakReference<NeatTextView> weakReference2) {
        AppMethodBeat.i(187935);
        if (map == null) {
            AppMethodBeat.o(187935);
            return null;
        }
        final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
        String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
        SpannableString spannableString = new SpannableString(nullAsNil);
        spannableString.setSpan(new a() {
            /* class com.tencent.mm.plugin.selectrecord.e.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.messenger.a.a
            public final void onClickImp(View view) {
                AppMethodBeat.i(187932);
                String r = b.r(map, "link_history");
                long j2 = bundle.getLong("msg_id");
                ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
                if (Hb.gDS()) {
                    h.a((Context) weakReference.get(), MMApplicationContext.getContext().getString(R.string.fwc), "", MMApplicationContext.getContext().getString(R.string.j34), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.selectrecord.e.b.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(187931);
                            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "click i know");
                            AppMethodBeat.o(187931);
                        }
                    });
                } else {
                    b.a(b.this, j2, map, bundle, r, weakReference);
                }
                b.a(bundle, Hb);
                ((e) com.tencent.mm.kernel.g.af(e.class)).a("link_history", map, bundle);
                AppMethodBeat.o(187932);
            }
        }, 0, nullAsNil.length(), 33);
        AppMethodBeat.o(187935);
        return spannableString;
    }

    private static void a(long j2, long j3, String str, String str2, String str3) {
        AppMethodBeat.i(187936);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI msgId:%s msgSvrId:%s sendUserName:%s talker:%s xml:%s", Long.valueOf(j2), Long.valueOf(j3), Util.nullAs(str, ""), Util.nullAs(str2, ""), Util.secPrint(str3));
        k.b HD = k.b.HD(str3);
        if (HD == null) {
            Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "gotoRecordDetailUI content is null???");
            AppMethodBeat.o(187936);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("message_id", j2);
        intent.putExtra("record_xml", HD.ixl);
        intent.putExtra("record_show_share", false);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j3));
        intent.putExtra("preUsername", str);
        intent.putExtra("preChatName", str2);
        intent.putExtra("preChatTYPE", 2);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
        AppMethodBeat.o(187936);
    }

    @Override // com.tencent.mm.plugin.selectrecord.e.a
    public final void I(long j2, String str) {
        AppMethodBeat.i(187937);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "onClickHistory msgId:%s", Long.valueOf(j2));
        if (this.isLoading) {
            if (this.gtM != null) {
                this.gtM.dismiss();
            }
            a(j2, this.dTS, this.CXg, this.talker, str);
        }
        AppMethodBeat.o(187937);
    }

    public static void a(long j2, Map<String, String> map, String str, a aVar) {
        AppMethodBeat.i(187938);
        if (aVar != null) {
            oPn.put(Long.valueOf(j2), aVar);
        }
        String nullAs = Util.nullAs(map.get(str + ".fileid"), "");
        String nullAs2 = Util.nullAs(map.get(str + ".aeskey"), "");
        String nullAs3 = Util.nullAs(map.get(str + ".filelength"), "");
        Util.nullAs(map.get(str + ".msgcount"), "");
        String str2 = PluginMessenger.getAccSelectRecordPath() + "downloadcache/";
        if (!s.YS(str2)) {
            s.boN(str2);
        }
        String str3 = str2 + j2;
        if (s.YS(str3)) {
            s.deleteFile(str3);
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + j2).getBytes());
        g gVar = new g();
        gVar.gqy = iZc;
        gVar.ehd = false;
        gVar.field_mediaId = messageDigest;
        gVar.field_fullpath = str3;
        gVar.field_totalLen = Integer.parseInt(nullAs3);
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_fileId = nullAs;
        gVar.field_aesKey = nullAs2;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        CXi.put(messageDigest, new Pair<>(Long.valueOf(j2), str3));
        boolean b2 = f.baQ().b(gVar, -1);
        Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "add download cdn task : %b, msgId : %s", Boolean.valueOf(b2), Long.valueOf(j2));
        if (!b2) {
            Log.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "triggerErrorCallback errCode:%s errMsg:%s", 0, Util.nullAs("add to cdn failed", ""));
        }
        AppMethodBeat.o(187938);
    }

    public static String II(long j2) {
        AppMethodBeat.i(187939);
        String str = PluginMessenger.getAccSelectRecordPath() + j2;
        AppMethodBeat.o(187939);
        return str;
    }

    static /* synthetic */ String r(Map map, String str) {
        String str2;
        AppMethodBeat.i(187940);
        int i2 = 0;
        while (true) {
            String str3 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
            if (i2 != 0) {
                str2 = str3 + i2;
            } else {
                str2 = str3;
            }
            if (Util.isNullOrNil((String) map.get(str2))) {
                AppMethodBeat.o(187940);
                return null;
            } else if (Util.isEqual((String) map.get(str2 + ".$type"), str)) {
                AppMethodBeat.o(187940);
                return str2;
            } else {
                i2++;
            }
        }
    }

    static /* synthetic */ void a(b bVar, long j2, Map map, Bundle bundle, String str, WeakReference weakReference) {
        AppMethodBeat.i(187941);
        if (weakReference != null) {
            try {
                if (weakReference.get() != null) {
                    bVar.nhy = weakReference;
                    bVar.dTS = bundle.getLong("msg_sever_id");
                    bVar.talker = bundle.getString("conv_talker_username");
                    bVar.CXg = bundle.getString("send_msg_username");
                    bVar.CXh = II(j2);
                    if (s.YS(bVar.CXh)) {
                        a(j2, bVar.dTS, bVar.CXg, bVar.talker, new String(s.aW(bVar.CXh, 0, -1)));
                        AppMethodBeat.o(187941);
                        return;
                    }
                    bVar.isLoading = true;
                    Context context = (Context) weakReference.get();
                    if (bVar.gtM == null) {
                        context.getString(R.string.zb);
                        bVar.gtM = h.a(context, context.getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.selectrecord.e.b.AnonymousClass3 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(187933);
                                b.this.isLoading = false;
                                AppMethodBeat.o(187933);
                            }
                        });
                    } else if (!bVar.gtM.isShowing()) {
                        bVar.gtM.show();
                    }
                    a(j2, map, str, bVar);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(187941);
                return;
            }
        }
        AppMethodBeat.o(187941);
    }

    static /* synthetic */ void a(Bundle bundle, ca caVar) {
        boolean z;
        int i2;
        AppMethodBeat.i(187942);
        String string = bundle.getString("conv_talker_username", null);
        if (Util.isEqual(bundle.getString(MessengerShareContentUtility.TEMPLATE_TYPE), "tmpl_type_profilewithrevoke")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        long parseLong = Long.parseLong(caVar.field_historyId);
        ib ibVar = new ib();
        ibVar.eMN = ibVar.x("RoomId", string, true);
        ibVar.eMO = (long) i2;
        ibVar.eMP = parseLong;
        Log.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryCheck %s", ibVar.abW());
        ibVar.bfK();
        AppMethodBeat.o(187942);
    }
}
