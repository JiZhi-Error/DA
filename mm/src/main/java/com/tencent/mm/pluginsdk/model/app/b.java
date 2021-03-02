package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;

public final class b {
    public long JVK;
    public String desc;
    public int jjS;
    public long jmW;
    public String md5;
    public int size;
    public String url;

    public static b gmM() {
        AppMethodBeat.i(30997);
        bg.aVF();
        String str = (String) c.azQ().get(352273, "");
        if (!Util.isNullOrNil(str)) {
            b bVar = new b(str);
            if (!bVar.isValid() || bVar.isExpired()) {
                gmN();
                AppMethodBeat.o(30997);
                return null;
            }
            AppMethodBeat.o(30997);
            return bVar;
        }
        AppMethodBeat.o(30997);
        return null;
    }

    public b(String str) {
        AppMethodBeat.i(30998);
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        this.desc = parseXml.get(".msg.appmsg.des");
        this.jjS = Util.getInt(parseXml.get(".msg.alphainfo.clientVersion"), 0);
        this.url = parseXml.get(".msg.alphainfo.url");
        this.size = Util.getInt(parseXml.get(".msg.alphainfo.size"), 0);
        this.md5 = parseXml.get(".msg.alphainfo.md5");
        this.JVK = Util.getLong(parseXml.get(".msg.alphainfo.maxAge"), 0);
        this.jmW = Util.getLong(parseXml.get(".msg.alphainfo.expireTime"), 0);
        Log.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.jjS), this.url, Integer.valueOf(this.size), this.md5, this.desc, Long.valueOf(this.JVK), Long.valueOf(this.jmW));
        AppMethodBeat.o(30998);
    }

    private boolean isValid() {
        boolean z;
        AppMethodBeat.i(30999);
        if (this.jjS <= d.KyO || Util.isNullOrNil(this.url) || Util.isNullOrNil(this.md5) || Util.isNullOrNil(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        AppMethodBeat.o(30999);
        return z;
    }

    private boolean isExpired() {
        boolean z;
        AppMethodBeat.i(31000);
        bg.aVF();
        if (System.currentTimeMillis() - ((Long) c.azQ().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.JVK || System.currentTimeMillis() > this.jmW) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        AppMethodBeat.o(31000);
        return z;
    }

    public static void gmN() {
        AppMethodBeat.i(31001);
        bg.aVF();
        c.azQ().set(352273, (Object) null);
        bg.aVF();
        c.azQ().set(352274, (Object) null);
        AppMethodBeat.o(31001);
    }

    public final void gmO() {
        AppMethodBeat.i(31002);
        ca caVar = new ca();
        caVar.setCreateTime(bp.C("weixin", Util.nowSecond()));
        caVar.setType(1);
        caVar.setContent(this.desc);
        Log.d("MicroMsg.AlphaUpdateInfo", caVar.field_content);
        caVar.nv(0);
        caVar.Cy("weixin");
        caVar.setStatus(3);
        bp.x(caVar);
        Log.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        gmN();
        AppMethodBeat.o(31002);
    }

    public final void gmP() {
        AppMethodBeat.i(31003);
        Log.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (!isValid() || isExpired()) {
            AppMethodBeat.o(31003);
        } else if (!gmQ()) {
            gmO();
            AppMethodBeat.o(31003);
        } else {
            Log.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.md5, Integer.valueOf(this.size), this.desc, this.url);
            com.tencent.mm.plugin.p.d.elq().h(this.md5, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
            AppMethodBeat.o(31003);
        }
    }

    private static boolean gmQ() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(31004);
        if (Util.safeParseInt(h.aqJ().getValue("SilentDownloadApkAtWiFi")) != 0) {
            AppMethodBeat.o(31004);
        } else {
            bg.aVF();
            boolean z3 = (((Integer) c.azQ().get(7, 0)).intValue() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0;
            if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()) || !z3) {
                z = false;
            }
            if ((ChannelUtil.updateMode & 1) != 0) {
                Log.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
            } else {
                Log.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                z2 = z;
            }
            AppMethodBeat.o(31004);
        }
        return z2;
    }
}
