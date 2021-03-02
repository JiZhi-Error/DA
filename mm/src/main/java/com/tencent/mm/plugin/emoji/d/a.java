package com.tencent.mm.plugin.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.d;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements c {
    @Override // com.tencent.mm.av.a.c.c
    public final b OV(String str) {
        String str2;
        int i2;
        String str3;
        Exception e2;
        IOException e3;
        SocketTimeoutException e4;
        SocketException e5;
        SSLHandshakeException e6;
        UnknownHostException e7;
        InterruptedException e8;
        ProtocolException e9;
        int i3;
        AppMethodBeat.i(104565);
        String str4 = "";
        try {
            d.b bVar = new d.b(str);
            if (!Util.isNullOrNil(bVar.ip)) {
                str4 = bVar.ip;
            }
            str3 = bVar.ip;
            try {
                i3 = bVar.jDL;
            } catch (ProtocolException e10) {
                e9 = e10;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e9));
                h.INSTANCE.idkeyStat(315, 7, 1, false);
                d.reportFailIp(str2);
                b bVar2 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2;
            } catch (InterruptedException e11) {
                e8 = e11;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e8));
                h.INSTANCE.idkeyStat(315, 0, 1, false);
                d.reportFailIp(str2);
                b bVar22 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar22;
            } catch (UnknownHostException e12) {
                e7 = e12;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e7));
                h.INSTANCE.idkeyStat(315, 1, 1, false);
                d.reportFailIp(str2);
                b bVar222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar222;
            } catch (SSLHandshakeException e13) {
                e6 = e13;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e6));
                h.INSTANCE.idkeyStat(315, 2, 1, false);
                d.reportFailIp(str2);
                b bVar2222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2222;
            } catch (SocketException e14) {
                e5 = e14;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e5));
                h.INSTANCE.idkeyStat(315, 3, 1, false);
                d.reportFailIp(str2);
                b bVar22222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar22222;
            } catch (SocketTimeoutException e15) {
                e4 = e15;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e4));
                h.INSTANCE.idkeyStat(315, 4, 1, false);
                d.reportFailIp(str2);
                b bVar222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar222222;
            } catch (IOException e16) {
                e3 = e16;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e3));
                h.INSTANCE.idkeyStat(315, 5, 1, false);
                d.reportFailIp(str2);
                b bVar2222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2222222;
            } catch (Exception e17) {
                e2 = e17;
                i2 = 0;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e2));
                h.INSTANCE.idkeyStat(315, 6, 1, false);
                d.reportFailIp(str2);
                b bVar22222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar22222222;
            }
            try {
                b c2 = C0957a.c(str, bVar);
                AppMethodBeat.o(104565);
                return c2;
            } catch (ProtocolException e18) {
                e9 = e18;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e9));
                h.INSTANCE.idkeyStat(315, 7, 1, false);
                if (i2 == 1 && NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    d.reportFailIp(str2);
                }
                b bVar222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar222222222;
            } catch (InterruptedException e19) {
                e8 = e19;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e8));
                h.INSTANCE.idkeyStat(315, 0, 1, false);
                d.reportFailIp(str2);
                b bVar2222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2222222222;
            } catch (UnknownHostException e20) {
                e7 = e20;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e7));
                h.INSTANCE.idkeyStat(315, 1, 1, false);
                d.reportFailIp(str2);
                b bVar22222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar22222222222;
            } catch (SSLHandshakeException e21) {
                e6 = e21;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e6));
                h.INSTANCE.idkeyStat(315, 2, 1, false);
                d.reportFailIp(str2);
                b bVar222222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar222222222222;
            } catch (SocketException e22) {
                e5 = e22;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e5));
                h.INSTANCE.idkeyStat(315, 3, 1, false);
                d.reportFailIp(str2);
                b bVar2222222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2222222222222;
            } catch (SocketTimeoutException e23) {
                e4 = e23;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e4));
                h.INSTANCE.idkeyStat(315, 4, 1, false);
                d.reportFailIp(str2);
                b bVar22222222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar22222222222222;
            } catch (IOException e24) {
                e3 = e24;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e3));
                h.INSTANCE.idkeyStat(315, 5, 1, false);
                d.reportFailIp(str2);
                b bVar222222222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar222222222222222;
            } catch (Exception e25) {
                e2 = e25;
                i2 = i3;
                str2 = str4;
                Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e2));
                h.INSTANCE.idkeyStat(315, 6, 1, false);
                d.reportFailIp(str2);
                b bVar2222222222222222 = new b(null, null);
                AppMethodBeat.o(104565);
                return bVar2222222222222222;
            }
        } catch (ProtocolException e26) {
            e9 = e26;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e9));
            h.INSTANCE.idkeyStat(315, 7, 1, false);
            d.reportFailIp(str2);
            b bVar22222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar22222222222222222;
        } catch (InterruptedException e27) {
            e8 = e27;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e8));
            h.INSTANCE.idkeyStat(315, 0, 1, false);
            d.reportFailIp(str2);
            b bVar222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar222222222222222222;
        } catch (UnknownHostException e28) {
            e7 = e28;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e7));
            h.INSTANCE.idkeyStat(315, 1, 1, false);
            d.reportFailIp(str2);
            b bVar2222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar2222222222222222222;
        } catch (SSLHandshakeException e29) {
            e6 = e29;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e6));
            h.INSTANCE.idkeyStat(315, 2, 1, false);
            d.reportFailIp(str2);
            b bVar22222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar22222222222222222222;
        } catch (SocketException e30) {
            e5 = e30;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e5));
            h.INSTANCE.idkeyStat(315, 3, 1, false);
            d.reportFailIp(str2);
            b bVar222222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar222222222222222222222;
        } catch (SocketTimeoutException e31) {
            e4 = e31;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e4));
            h.INSTANCE.idkeyStat(315, 4, 1, false);
            d.reportFailIp(str2);
            b bVar2222222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar2222222222222222222222;
        } catch (IOException e32) {
            e3 = e32;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e3));
            h.INSTANCE.idkeyStat(315, 5, 1, false);
            d.reportFailIp(str2);
            b bVar22222222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar22222222222222222222222;
        } catch (Exception e33) {
            e2 = e33;
            i2 = 0;
            str3 = "";
            str2 = str4;
            Log.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i2), Util.stackTraceToString(e2));
            h.INSTANCE.idkeyStat(315, 6, 1, false);
            d.reportFailIp(str2);
            b bVar222222222222222222222222 = new b(null, null);
            AppMethodBeat.o(104565);
            return bVar222222222222222222222222;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.d.a$a  reason: collision with other inner class name */
    static class C0957a {
        private static y b(String str, d.b bVar) {
            y a2;
            AppMethodBeat.i(104563);
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_httpurlconnection_in_cronet, false)) {
                a2 = d.RQ(str);
                ((z) a2).jFq = 1195;
                ((z) a2).jFr = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_cronet_use_newdns, false);
                h.INSTANCE.idkeyStat(1195, 96, 1, false);
            } else {
                a2 = d.a(str, bVar);
                h.INSTANCE.idkeyStat(1195, 95, 1, false);
            }
            String str2 = "";
            if (MMApplicationContext.isMMProcess() && g.aAc()) {
                g.aAf();
                str2 = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d", Integer.valueOf(com.tencent.mm.protocal.d.KyO), p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())));
            }
            Log.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", str2);
            a2.setRequestMethod("GET");
            a2.setRequestProperty("referer", str2);
            a2.setConnectTimeout(15000);
            a2.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            AppMethodBeat.o(104563);
            return a2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.av.a.d.b c(java.lang.String r21, com.tencent.mm.network.d.b r22) {
            /*
            // Method dump skipped, instructions count: 430
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.d.a.C0957a.c(java.lang.String, com.tencent.mm.network.d$b):com.tencent.mm.av.a.d.b");
        }
    }
}
