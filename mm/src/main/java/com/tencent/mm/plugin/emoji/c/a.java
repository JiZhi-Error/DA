package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.a.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;

public final class a extends IListener<ps> {
    public a() {
        AppMethodBeat.i(161065);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161065);
    }

    public static void lq(boolean z) {
        long j2;
        boolean z2;
        AppMethodBeat.i(108383);
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_LONG, (Object) null);
        if (obj == null || !(obj instanceof Long)) {
            j2 = 0;
        } else {
            j2 = ((Long) obj).longValue();
        }
        if (System.currentTimeMillis() - j2 > Util.MILLSECONDS_OF_DAY) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || z) {
            boolean gEP = k.getEmojiStorageMgr().OpO.gEP();
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", Boolean.valueOf(gEP));
            if (gEP || z) {
                g.aAg().hqi.a(new t(k.getEmojiStorageMgr().OpO.gER(), 1), 0);
                AppMethodBeat.o(108383);
                return;
            }
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.TRUE);
        }
        AppMethodBeat.o(108383);
    }

    public static void lr(boolean z) {
        boolean z2;
        AppMethodBeat.i(108384);
        if (Util.nullAs((Boolean) g.aAh().azQ().get(348165, (Object) null), false)) {
            Object obj = g.aAh().azQ().get(348166, (Object) null);
            z2 = System.currentTimeMillis() - ((obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue()) > Util.MILLSECONDS_OF_HOUR;
        } else {
            z2 = false;
        }
        if (z2 || z) {
            ArrayList<String> gFn = k.getEmojiStorageMgr().OpN.gFn();
            if (gFn.size() > 0) {
                Log.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", Integer.valueOf(gFn.size()));
                ArrayList arrayList = new ArrayList();
                int size = gFn.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new c(gFn.get(i2)));
                    Log.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", gFn.get(i2));
                }
                k.cGg().rds.dh(arrayList);
                k.cGg().rds.cGC();
            } else {
                Log.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                g.aAh().azQ().set(348165, Boolean.FALSE);
            }
            g.aAh().azQ().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(108384);
    }

    public static void cFr() {
        boolean z;
        AppMethodBeat.i(108385);
        boolean nullAs = Util.nullAs((Boolean) g.aAh().azQ().get(348162, (Object) null), false);
        if (Util.nullAs((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, (Object) null), false) || !nullAs) {
            z = false;
        } else {
            Object obj = g.aAh().azQ().get(348163, (Object) null);
            z = System.currentTimeMillis() - ((obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue()) > Util.MILLSECONDS_OF_HOUR;
        }
        if (z) {
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) k.getEmojiStorageMgr().OpN.aks(0);
            if (arrayList.size() <= 0) {
                Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                g.aAh().azQ().set(348162, Boolean.FALSE);
                AppMethodBeat.o(108385);
                return;
            }
            g.aAh().azQ().set(348163, Long.valueOf(System.currentTimeMillis()));
            Log.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                int i2 = size / 50;
                Log.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", Integer.valueOf(i2));
                for (int i3 = 0; i3 <= i2; i3++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = i3 * 50;
                    int i5 = ((i3 + 1) * 50) + -1 >= size ? size : (i3 + 1) * 50;
                    Log.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", Integer.valueOf(i4), Integer.valueOf(i5));
                    if (i5 > i4) {
                        arrayList2.addAll(arrayList.subList(i4, i5));
                        g.aAg().hqi.a(new d(arrayList2), 0);
                    }
                }
                AppMethodBeat.o(108385);
                return;
            }
            g.aAg().hqi.a(new d(arrayList), 0);
        }
        AppMethodBeat.o(108385);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0136  */
    @Override // com.tencent.mm.sdk.event.IListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean callback(com.tencent.mm.g.a.ps r14) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.c.a.callback(com.tencent.mm.sdk.event.IEvent):boolean");
    }
}
