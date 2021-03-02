package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.o;
import com.tencent.mm.ce.e;
import com.tencent.mm.ce.f;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class b {
    public static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass6 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(108402);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    dj djVar = new dj();
                    djVar.dGu.state = 1;
                    EventCenter.instance.publish(djVar);
                }
            }
            AppMethodBeat.o(108402);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(108403);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    dj djVar = new dj();
                    djVar.dGu.state = 0;
                    EventCenter.instance.publish(djVar);
                }
            }
            AppMethodBeat.o(108403);
        }
    };
    public final IListener checkLanguageChangeIListener = new IListener<bn>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass9 */

        {
            AppMethodBeat.i(161076);
            this.__eventId = bn.class.getName().hashCode();
            AppMethodBeat.o(161076);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bn bnVar) {
            AppMethodBeat.i(108406);
            bf emojiDescMgr = k.getEmojiDescMgr();
            String lowerCase = LocaleUtil.getApplicationLanguage().toLowerCase();
            Log.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", lowerCase, emojiDescMgr.Opi);
            if (!emojiDescMgr.mInit || (!Util.isNullOrNil(emojiDescMgr.Opi) && !emojiDescMgr.Opi.equalsIgnoreCase(lowerCase))) {
                emojiDescMgr.gCG();
            }
            j.auL().dX(true);
            AppMethodBeat.o(108406);
            return false;
        }
    };
    public com.tencent.mm.plugin.emoji.c.a qZf = new com.tencent.mm.plugin.emoji.c.a();
    public com.tencent.mm.plugin.emoji.c.b qZg = new com.tencent.mm.plugin.emoji.c.b();
    public d qZh = new d();
    public c qZi = new c();
    public IListener qZj = new IListener<yx>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161069);
            this.__eventId = yx.class.getName().hashCode();
            AppMethodBeat.o(161069);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yx yxVar) {
            EmojiInfo emojiInfo;
            AppMethodBeat.i(108396);
            ca caVar = yxVar.efh.dCM;
            EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(caVar.field_imgPath);
            if (blk != null) {
                if (blk.field_type == EmojiInfo.VkX) {
                    Cursor cursor = null;
                    if (EmojiInfo.axs(blk.field_catalog)) {
                        cursor = k.getEmojiStorageMgr().OpN.aku(blk.field_catalog);
                    } else if (blk.field_catalog == EmojiInfo.VkS && blk.getContent().length() > 0 && EmojiInfo.axs(Util.getInt(blk.getContent(), 0))) {
                        cursor = k.getEmojiStorageMgr().OpN.aku(Util.getInt(blk.getContent(), 0));
                    }
                    if (cursor != null) {
                        int intRandom = Util.getIntRandom(cursor.getCount() - 1, 0);
                        EmojiInfo emojiInfo2 = new EmojiInfo();
                        cursor.moveToPosition(intRandom);
                        emojiInfo2.convertFrom(cursor);
                        cursor.close();
                        emojiInfo = emojiInfo2;
                    } else {
                        emojiInfo = blk;
                    }
                    caVar.Cz(emojiInfo.getMd5());
                    caVar.nc(0);
                    be bkr = be.bkr(caVar.field_content);
                    bkr.jsi = false;
                    caVar.setStatus(1);
                    caVar.setContent(bkr.bie());
                    ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
                } else {
                    emojiInfo = blk;
                }
                k.cGf().a(caVar.field_talker, emojiInfo, caVar);
            }
            AppMethodBeat.o(108396);
            return false;
        }
    };
    public IListener qZk = new IListener<mi>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass4 */

        {
            AppMethodBeat.i(161072);
            this.__eventId = mi.class.getName().hashCode();
            AppMethodBeat.o(161072);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mi miVar) {
            AppMethodBeat.i(108400);
            boolean a2 = a(miVar);
            AppMethodBeat.o(108400);
            return a2;
        }

        private static boolean a(mi miVar) {
            AppMethodBeat.i(108399);
            if (miVar != null && (miVar instanceof mi)) {
                Log.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (miVar.dRI.result) {
                    g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            AppMethodBeat.o(108399);
            return false;
        }
    };
    public IListener qZl = new IListener<dj>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass5 */

        {
            AppMethodBeat.i(161073);
            this.__eventId = dj.class.getName().hashCode();
            AppMethodBeat.o(161073);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dj djVar) {
            boolean z;
            AppMethodBeat.i(108401);
            switch (djVar.dGu.state) {
                case 0:
                    d cFF = d.cFF();
                    com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
                    String awt = com.tencent.mm.emoji.e.a.awt();
                    cFF.qZA = true;
                    if (!Util.isNullOrNil(awt)) {
                        if (System.currentTimeMillis() - ((Long) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, (Object) 0L)).longValue() >= Util.MILLSECONDS_OF_DAY) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Log.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", Boolean.valueOf(z));
                        if (z) {
                            Log.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            g.aAk().postToWorker(new Runnable(awt) {
                                /* class com.tencent.mm.plugin.emoji.e.d.AnonymousClass1 */
                                final /* synthetic */ String val$filePath;

                                {
                                    this.val$filePath = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(108422);
                                    d.this.amj(this.val$filePath);
                                    if (d.this.qZA) {
                                        g.aAh().azQ().set(ar.a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
                                    }
                                    AppMethodBeat.o(108422);
                                }
                            });
                            break;
                        }
                    } else {
                        Log.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                        break;
                    }
                    break;
                case 1:
                    d.cFF().qZA = false;
                    break;
            }
            AppMethodBeat.o(108401);
            return false;
        }
    };
    public IListener qZm = new IListener<di>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass7 */

        {
            AppMethodBeat.i(161074);
            this.__eventId = di.class.getName().hashCode();
            AppMethodBeat.o(161074);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(di diVar) {
            AppMethodBeat.i(108404);
            di diVar2 = diVar;
            c cFD = c.cFD();
            if (diVar2 != null && (diVar2 instanceof di)) {
                di diVar3 = diVar2;
                switch (diVar3.dGs.scene) {
                    case 0:
                        g.aAk().postToWorker(new Runnable(diVar3.dGs.dGt) {
                            /* class com.tencent.mm.plugin.emoji.e.c.AnonymousClass1 */
                            final /* synthetic */ EmojiInfo qZx;

                            {
                                this.qZx = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(108412);
                                if (this.qZx != null && !this.qZx.hYi()) {
                                    Log.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", this.qZx.getMd5());
                                    c.b(this.qZx, true);
                                }
                                AppMethodBeat.o(108412);
                            }
                        });
                        break;
                    case 1:
                        g.aAk().postToWorker(new Runnable(diVar3.dGs.dGt) {
                            /* class com.tencent.mm.plugin.emoji.e.c.AnonymousClass2 */
                            final /* synthetic */ EmojiInfo qZx;

                            {
                                this.qZx = r2;
                            }

                            public final void run() {
                                EmojiGroupInfo di;
                                boolean z = true;
                                AppMethodBeat.i(108413);
                                if (this.qZx != null && !this.qZx.hYi()) {
                                    String str = this.qZx.field_groupId;
                                    if (Util.isNullOrNil(str) || (di = k.getEmojiStorageMgr().OpO.di(str, true)) == null || di.field_sync <= 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        c.a(c.this, this.qZx);
                                        AppMethodBeat.o(108413);
                                        return;
                                    }
                                    c.b(this.qZx, false);
                                }
                                AppMethodBeat.o(108413);
                            }
                        });
                        break;
                }
            }
            AppMethodBeat.o(108404);
            return false;
        }
    };
    public IListener qZn = new IListener<bi>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass8 */

        {
            AppMethodBeat.i(161075);
            this.__eventId = bi.class.getName().hashCode();
            AppMethodBeat.o(161075);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bi biVar) {
            EmojiInfo blm;
            AppMethodBeat.i(108405);
            bi biVar2 = biVar;
            int i2 = biVar2.dEx.type;
            if (i2 == 0) {
                EmojiInfo emojiInfo = biVar2.dEx.dEz;
                if (emojiInfo != null && emojiInfo.hYi()) {
                    biVar2.dEy.result = com.tencent.mm.emoji.decode.a.aum().b(emojiInfo);
                    if (!biVar2.dEy.result) {
                        h.INSTANCE.idkeyStat(252, 8, 1, false);
                    }
                }
            } else if (i2 == 1) {
                String str = biVar2.dEx.dEA;
                if (!Util.isNullOrNil(str) && (blm = k.getEmojiStorageMgr().OpN.blm(str)) != null && blm.hYi()) {
                    biVar2.dEy.result = com.tencent.mm.emoji.decode.a.aum().b(blm);
                    if (!biVar2.dEy.result) {
                        h.INSTANCE.idkeyStat(252, 9, 1, false);
                    }
                }
            }
            AppMethodBeat.o(108405);
            return false;
        }
    };
    public IListener qZo = new IListener<ql>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass10 */

        {
            AppMethodBeat.i(161077);
            this.__eventId = ql.class.getName().hashCode();
            AppMethodBeat.o(161077);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ql qlVar) {
            AppMethodBeat.i(108407);
            ql qlVar2 = qlVar;
            if (!(qlVar2 == null || !(qlVar2 instanceof ql) || qlVar2.dWU == null)) {
                String str = qlVar2.dWU.productId;
                if (!Util.isNullOrNil(str) && k.getEmojiStorageMgr().OpO.blb(str)) {
                    k.getEmojiDescMgr().gCG();
                }
            }
            AppMethodBeat.o(108407);
            return false;
        }
    };
    public IListener qZp = new IListener<dk>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass11 */

        {
            AppMethodBeat.i(161078);
            this.__eventId = dk.class.getName().hashCode();
            AppMethodBeat.o(161078);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dk dkVar) {
            AppMethodBeat.i(108409);
            boolean a2 = a(dkVar);
            AppMethodBeat.o(108409);
            return a2;
        }

        private static boolean a(dk dkVar) {
            AppMethodBeat.i(108408);
            if (dkVar != null && (dkVar instanceof dk)) {
                boolean z = dkVar.dGv.enable;
                g.aAh().azQ().set(ar.a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.valueOf(z));
                k.cGj().ray = z;
                if (!z) {
                    h.INSTANCE.a(12953, 2, "");
                    Toast.makeText(MMApplicationContext.getContext(), (int) R.string.brx, 0).show();
                } else {
                    Toast.makeText(MMApplicationContext.getContext(), (int) R.string.brz, 0).show();
                }
            }
            AppMethodBeat.o(108408);
            return false;
        }
    };
    public IListener qZq = new IListener<dh>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass2 */

        {
            AppMethodBeat.i(161070);
            this.__eventId = dh.class.getName().hashCode();
            AppMethodBeat.o(161070);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dh dhVar) {
            AppMethodBeat.i(108397);
            switch (dhVar.dGr.subType) {
                case 1:
                    f.gxT().gxW();
                    e.gxR().cbZ();
                    EventCenter.instance.publish(new rj());
                    break;
                case 2:
                    e.gxR().cbZ();
                    EventCenter.instance.publish(new rj());
                    break;
                default:
                    Log.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            AppMethodBeat.o(108397);
            return false;
        }
    };
    public IListener qZr = new IListener<ki>() {
        /* class com.tencent.mm.plugin.emoji.e.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161071);
            this.__eventId = ki.class.getName().hashCode();
            AppMethodBeat.o(161071);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ki kiVar) {
            AppMethodBeat.i(108398);
            switch (kiVar.dPs.errorCode) {
                case 101:
                    h.INSTANCE.idkeyStat(401, 3, 1, false);
                    break;
                case 102:
                    h.INSTANCE.idkeyStat(401, 4, 1, false);
                    break;
                case 104:
                    h.INSTANCE.idkeyStat(401, 6, 1, false);
                    break;
                case 105:
                    h.INSTANCE.idkeyStat(401, 7, 1, false);
                    break;
                case 106:
                    h.INSTANCE.idkeyStat(401, 8, 1, false);
                    break;
                case 107:
                    h.INSTANCE.idkeyStat(401, 9, 1, false);
                    break;
                case 108:
                    h.INSTANCE.idkeyStat(401, 10, 1, false);
                    break;
                case 109:
                    h.INSTANCE.idkeyStat(401, 11, 1, false);
                    break;
                case 110:
                    h.INSTANCE.idkeyStat(401, 12, 1, false);
                    break;
                case 111:
                    h.INSTANCE.idkeyStat(401, 13, 1, false);
                    break;
                case 112:
                    h.INSTANCE.idkeyStat(401, 14, 1, false);
                    break;
                case 113:
                    h.INSTANCE.idkeyStat(401, 15, 1, false);
                    break;
            }
            AppMethodBeat.o(108398);
            return false;
        }
    };

    static {
        AppMethodBeat.i(108411);
        AppMethodBeat.o(108411);
    }

    public b() {
        AppMethodBeat.i(108410);
        AppMethodBeat.o(108410);
    }
}
