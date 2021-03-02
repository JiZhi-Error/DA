package com.tencent.mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.br;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger extends f implements i, c, com.tencent.mm.plugin.messenger.a.c {
    private e.d UYH = new e.d() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass9 */

        @Override // com.tencent.mm.plugin.messenger.a.e.d
        public final Boolean cE(Map<String, String> map) {
            AppMethodBeat.i(259553);
            Boolean valueOf = Boolean.valueOf(map.containsKey(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo"));
            AppMethodBeat.o(259553);
            return valueOf;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v2, resolved type: android.text.SpannableString */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.plugin.messenger.a.e.d
        public final CharSequence V(Map<String, String> map, String str) {
            String str2;
            AppMethodBeat.i(259554);
            final Long valueOf = Long.valueOf(d.Ga(Util.nullAsNil(map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectid"))));
            final Long valueOf2 = Long.valueOf(d.Ga(Util.nullAsNil(map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "liveid"))));
            final String nullAsNil = Util.nullAsNil(map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectnonceid"));
            String nullAsNil2 = Util.nullAsNil(map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "findernickname"));
            final String nullAsNil3 = Util.nullAsNil(map.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "redpacketsendid"));
            String string = MMApplicationContext.getContext().getResources().getString(R.string.jbt);
            String string2 = MMApplicationContext.getContext().getResources().getString(R.string.jbu, nullAsNil2, string);
            int indexOf = string2.indexOf(string);
            if (indexOf == -1 || string.length() + indexOf > string2.length()) {
                AppMethodBeat.o(259554);
                str2 = str;
            } else {
                SpannableString c2 = l.c(MMApplicationContext.getContext(), string2);
                Drawable drawable = MMApplicationContext.getContext().getDrawable(MMApplicationContext.getContext().getResources().getIdentifier("systemmessages_hongbaoicon", "drawable", MMApplicationContext.getContext().getPackageName()));
                if (drawable != null) {
                    int dimensionPixelOffset = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(R.dimen.aqm);
                    drawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
                    a aVar = new a(drawable, 1);
                    int indexOf2 = string2.indexOf(8197);
                    if (indexOf2 >= 0 && indexOf2 < string2.length() - 1) {
                        c2.setSpan(aVar, indexOf2, indexOf2 + 1, 18);
                    }
                }
                c2.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                    /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.messenger.a.a
                    public final void onClickImp(View view) {
                        AppMethodBeat.i(259552);
                        ((aj) g.ah(aj.class)).report21053OnClick(valueOf.longValue(), valueOf2.longValue(), "", -1, -1, -1, "temp_17", -1, -1, "", "", System.currentTimeMillis(), -1);
                        ((aj) g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), valueOf.longValue(), valueOf2, "", nullAsNil, "", "", "", nullAsNil3, 0);
                        AppMethodBeat.o(259552);
                    }
                }, indexOf, string.length() + indexOf, 33);
                AppMethodBeat.o(259554);
                str2 = c2;
            }
            return str2;
        }
    };
    private ProgressDialog gtM = null;
    private q zoE;
    a zoF = new a();
    private com.tencent.mm.plugin.messenger.d.a zoG = new com.tencent.mm.plugin.messenger.d.a();
    private com.tencent.mm.plugin.messenger.d.d zoH = new com.tencent.mm.plugin.messenger.d.d();
    private e.b zoI = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, WeakReference weakReference, WeakReference weakReference2) {
            AppMethodBeat.i(194458);
            if (map == null) {
                AppMethodBeat.o(194458);
                return null;
            }
            SpannableString spannableString = new SpannableString(Util.nullAsNil((String) map.get(str + ".plain")));
            AppMethodBeat.o(194458);
            return spannableString;
        }
    };
    private e.b zoJ = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass12 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final /* synthetic */ CharSequence a(final Map map, final String str, final Bundle bundle, final WeakReference weakReference, final WeakReference weakReference2) {
            AppMethodBeat.i(194471);
            if (map == null) {
                AppMethodBeat.o(194471);
                return null;
            }
            final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
            PluginMessenger.access$000(PluginMessenger.this, map, str, bundle, weakReference, string, false);
            String nullAsNil = Util.nullAsNil((String) map.get(str + ".title"));
            SpannableString spannableString = new SpannableString(nullAsNil);
            spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass12.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.messenger.a.a
                public final void onClickImp(View view) {
                    AppMethodBeat.i(90711);
                    PluginMessenger.access$000(PluginMessenger.this, map, str, bundle, weakReference, string, true);
                    ((e) g.af(e.class)).a("link_succeed_contact", map, bundle);
                    AppMethodBeat.o(90711);
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.o(194471);
            return spannableString;
        }
    };
    private e.b zoK = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass14 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final /* synthetic */ CharSequence a(final Map map, final String str, final Bundle bundle, final WeakReference weakReference, final WeakReference weakReference2) {
            AppMethodBeat.i(194473);
            if (map == null) {
                AppMethodBeat.o(194473);
                return null;
            }
            String nullAsNil = Util.nullAsNil((String) map.get(str + ".title"));
            SpannableString spannableString = new SpannableString(nullAsNil);
            spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass14.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.messenger.a.a
                public final void onClickImp(View view) {
                    AppMethodBeat.i(90713);
                    try {
                        String string = bundle.getString("send_msg_username", "");
                        String nullAs = Util.nullAs((String) map.get(str + ".chatname"), "");
                        gs gsVar = new gs();
                        gsVar.uv(string);
                        gsVar.eKO = 2;
                        gsVar.eKP = 2;
                        gsVar.eKS = 1;
                        gsVar.bfK();
                        PluginMessenger.access$100(PluginMessenger.this, nullAs);
                        ((e) g.af(e.class)).a("link_jump_chat", map, bundle);
                        AppMethodBeat.o(90713);
                    } catch (Throwable th) {
                        AppMethodBeat.o(90713);
                    }
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.o(194473);
            return spannableString;
        }
    };
    private e.a zoL = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass15 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90715);
            if (map == null) {
                AppMethodBeat.o(90715);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".plain"));
            AppMethodBeat.o(90715);
            return nullAsNil;
        }
    };
    private e.a zoM = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass16 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90716);
            if (map == null) {
                AppMethodBeat.o(90716);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(90716);
            return nullAsNil;
        }
    };
    private e.a zoN = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass17 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90717);
            if (map == null) {
                AppMethodBeat.o(90717);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(90717);
            return nullAsNil;
        }
    };
    private e.a zoO = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass18 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90718);
            if (map == null) {
                AppMethodBeat.o(90718);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(90718);
            return nullAsNil;
        }
    };
    private e.a zoP = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass19 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90719);
            if (map == null) {
                AppMethodBeat.o(90719);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(90719);
            return nullAsNil;
        }
    };
    private e.a zoQ = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass20 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(90720);
            StringBuilder sb = new StringBuilder();
            String nullAs = Util.nullAs(map.get(str + ".separator"), "、");
            int i2 = 0;
            while (true) {
                String str2 = str + ".memberlist.member" + (i2 != 0 ? Integer.valueOf(i2) : "");
                if (map.get(str2) != null) {
                    if (i2 != 0) {
                        sb.append(nullAs);
                    }
                    String str3 = map.get(str2 + ".nickname");
                    if (Util.isNullOrNil(str3)) {
                        Log.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
                    } else {
                        sb.append(str3);
                    }
                    i2++;
                } else {
                    String sb2 = sb.toString();
                    AppMethodBeat.o(90720);
                    return sb2;
                }
            }
        }
    };
    private e.a zoR = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(194459);
            if (map == null) {
                AppMethodBeat.o(194459);
                return null;
            }
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(194459);
            return nullAsNil;
        }
    };
    private e.a zoS = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(194460);
            if (map == null) {
                AppMethodBeat.o(194460);
                return null;
            } else if (map.containsKey(str + ".redpacketinfo")) {
                AppMethodBeat.o(194460);
                return "";
            } else {
                String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
                AppMethodBeat.o(194460);
                return nullAsNil;
            }
        }
    };
    private e.a zoT = new e.a() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.messenger.a.e.a
        public final String f(Map<String, String> map, String str) {
            AppMethodBeat.i(194461);
            if (map == null) {
                AppMethodBeat.o(194461);
                return null;
            }
            Log.d("MicroMsg.PluginMessenger", "mHandleNewLinkHistoryDigestListener %s", Util.nullAsNil(map.get(str + ".title")));
            String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
            AppMethodBeat.o(194461);
            return nullAsNil;
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.q zoU = new com.tencent.mm.plugin.messenger.foundation.a.q() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(194462);
            if ("secmsg".equals(str)) {
                String nullAsNil = Util.nullAsNil(map.get(".sysmsg.secmsg.session"));
                String nullAsNil2 = Util.nullAsNil(map.get(".sysmsg.secmsg.newmsgid"));
                int safeParseInt = Util.safeParseInt(map.get(".sysmsg.secmsg.sec_msg_node.sfn"));
                String nullAsNil3 = Util.nullAsNil(map.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
                int safeParseInt2 = Util.safeParseInt(map.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
                String nullAsNil4 = Util.nullAsNil(map.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
                int safeParseInt3 = Util.safeParseInt(map.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
                int safeParseInt4 = Util.safeParseInt(map.get(".sysmsg.secmsg.sec_msg_node.media-to-emoji"));
                int safeParseInt5 = Util.safeParseInt(map.get(".sysmsg.secmsg.sec_msg_node.block-range"));
                Log.i("MicroMsg.PluginMessenger", "msgId:%s [%d],[%s],[%d],[%s],[%d],[%d],[%d]", Long.valueOf(Util.safeParseLong(nullAsNil2)), Integer.valueOf(safeParseInt), nullAsNil3, Integer.valueOf(safeParseInt2), nullAsNil4, Integer.valueOf(safeParseInt3), Integer.valueOf(safeParseInt5), Integer.valueOf(safeParseInt4));
                HashMap hashMap = new HashMap();
                hashMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(safeParseInt));
                hashMap.put(".msgsource.sec_msg_node.show-h5", nullAsNil3);
                hashMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(safeParseInt2));
                hashMap.put(".msgsource.sec_msg_node.share-tip-url", nullAsNil4);
                hashMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(safeParseInt3));
                hashMap.put(".msgsource.sec_msg_node.media-to-emoji", String.valueOf(safeParseInt4));
                hashMap.put(".msgsource.sec_msg_node.block-range", String.valueOf(safeParseInt5));
                if (!Util.isNullOrNil(nullAsNil, nullAsNil2)) {
                    ca aJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(nullAsNil, Util.safeParseLong(nullAsNil2));
                    if (Util.isNullOrNil(aJ.field_talker) || aJ.field_msgSvrId <= 0) {
                        Log.i("MicroMsg.PluginMessenger", "msg %s not found!", nullAsNil2);
                        br.d(Util.safeParseLong(nullAsNil2), br.A(hashMap));
                    } else {
                        br.a(aJ, br.A(hashMap));
                        AppMethodBeat.o(194462);
                        return;
                    }
                }
            }
            AppMethodBeat.o(194462);
        }
    };
    private e.b zoV = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, final WeakReference weakReference, WeakReference weakReference2) {
            AppMethodBeat.i(194464);
            if (map == null) {
                AppMethodBeat.o(194464);
                return null;
            }
            final long safeParseLong = Util.safeParseLong((String) map.get(str + ".mmlive.live_id"));
            final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
            String nullAsNil = Util.nullAsNil((String) map.get(str + ".des"));
            final String nullAsNil2 = Util.nullAsNil((String) map.get(str + ".mmlive.identity_id"));
            SpannableString spannableString = new SpannableString(nullAsNil);
            spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass6.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.messenger.a.a
                public final void onClickImp(View view) {
                    AppMethodBeat.i(194463);
                    try {
                        if (weakReference.get() != null) {
                            LiveConfig.a aVar = new LiveConfig.a();
                            aVar.hvZ = LiveConfig.hvV;
                            aVar.hwa = string;
                            aVar.hwd = nullAsNil2;
                            aVar.liveId = safeParseLong;
                            aVar.scene = LiveConfig.hvR;
                            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context) weakReference.get(), aVar.aBR());
                        }
                        AppMethodBeat.o(194463);
                    } catch (Throwable th) {
                        AppMethodBeat.o(194463);
                    }
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.o(194464);
            return spannableString;
        }
    };
    private e.b zoW = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, WeakReference weakReference, WeakReference weakReference2) {
            AppMethodBeat.i(194465);
            if (map == null) {
                AppMethodBeat.o(194465);
                return null;
            }
            String nullAsNil = Util.nullAsNil((String) map.get(str + ".identity_id"));
            String nullAsNil2 = Util.nullAsNil((String) map.get(str + ".nickname"));
            String displayName = aa.getDisplayName(nullAsNil);
            if (!Util.isNullOrNil(displayName)) {
                nullAsNil2 = displayName;
            }
            SpannableString spannableString = new SpannableString(nullAsNil2);
            AppMethodBeat.o(194465);
            return spannableString;
        }
    };
    private e.b zoX = new e.b() {
        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.messenger.a.e.b
        public final CharSequence a(Map<String, String> map, String str, Bundle bundle, final WeakReference<Context> weakReference, WeakReference<NeatTextView> weakReference2) {
            AppMethodBeat.i(194467);
            if (map == null) {
                AppMethodBeat.o(194467);
                return null;
            } else if (map.containsKey(str + ".redpacketinfo")) {
                AppMethodBeat.o(194467);
                return "";
            } else {
                String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
                final String str2 = map.get(str + ".url");
                SpannableString spannableString = new SpannableString(nullAsNil);
                if (!TextUtils.isEmpty(str2)) {
                    spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass8.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.messenger.a.a
                        public final void onClickImp(View view) {
                            AppMethodBeat.i(194466);
                            Context context = (Context) weakReference.get();
                            if (context != null) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str2);
                                com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                            }
                            AppMethodBeat.o(194466);
                        }
                    }, 0, nullAsNil.length(), 33);
                }
                AppMethodBeat.o(194467);
                return spannableString;
            }
        }
    };

    public PluginMessenger() {
        AppMethodBeat.i(90721);
        AppMethodBeat.o(90721);
    }

    static /* synthetic */ void access$000(PluginMessenger pluginMessenger, Map map, String str, Bundle bundle, WeakReference weakReference, String str2, boolean z) {
        AppMethodBeat.i(90740);
        pluginMessenger.resolvedSucceedContactText(map, str, bundle, weakReference, str2, z);
        AppMethodBeat.o(90740);
    }

    static /* synthetic */ void access$100(PluginMessenger pluginMessenger, String str) {
        AppMethodBeat.i(90741);
        pluginMessenger.startChattingUI(str);
        AppMethodBeat.o(90741);
    }

    private void resolvedSucceedContactText(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, String str2, boolean z) {
        String str3;
        String str4;
        AppMethodBeat.i(90722);
        try {
            String nullAs = Util.nullAs(bundle.getString("local_session"), "");
            if (!(weakReference == null || weakReference.get() == null)) {
                int safeParseInt = Util.safeParseInt(map.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
                if ("tmpl_type_succeed_contact_window".equals(map.get(str + ".window_template.$type"))) {
                    String str5 = map.get(str + ".window_template.template");
                    String str6 = map.get(str + ".window_template.tp_username");
                    String str7 = map.get(str + ".window_template.headimgurl");
                    if (!Util.isNullOrNil(str7) && p.aYB().Mx(str6) == null) {
                        com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                        iVar.username = str6;
                        iVar.iKW = str7;
                        iVar.fuz = 3;
                        iVar.fv(false);
                        p.aYB().b(iVar);
                    }
                    if (!z || !isSwitchContact(str6, str2)) {
                        String str8 = map.get(str + ".window_template.ticket");
                        String str9 = map.get(str + ".window_template.antispam_ticket");
                        String str10 = map.get(str + ".window_template.title");
                        String str11 = map.get(str + ".window_template.cancel_wording");
                        String str12 = map.get(str + ".window_template.confirm_wording");
                        String str13 = "";
                        String str14 = "";
                        ArrayList<c.a> aFd = com.tencent.mm.plugin.messenger.d.c.aFd(str5);
                        if (aFd != null && aFd.size() > 0) {
                            ArrayList<CharSequence> arrayList = new ArrayList<>();
                            Iterator<c.a> it = aFd.iterator();
                            while (it.hasNext()) {
                                c.a next = it.next();
                                if (next != null && next.content != null) {
                                    if (next.type == 0) {
                                        arrayList.add(new SpannableString(l.c(MMApplicationContext.getContext(), next.content)));
                                    } else if (next.type == 1) {
                                        int i2 = 0;
                                        while (true) {
                                            String str15 = str + ".window_template.link_list.link";
                                            if (i2 != 0) {
                                                str3 = str15 + i2;
                                            } else {
                                                str3 = str15;
                                            }
                                            if (Util.isNullOrNil(map.get(str3))) {
                                                break;
                                            }
                                            String str16 = map.get(str3 + ".$name");
                                            String str17 = map.get(str3 + ".$type");
                                            if (next.content.equals(str16) && "link_plain".equals(str17)) {
                                                arrayList.add(nullAsNil(map.get(str3 + ".plain")));
                                            }
                                            if ("company".equals(str16) && "link_userdescid".equals(str17)) {
                                                str13 = nullAsNil(map.get(str3 + ".userdesc")).toString();
                                            }
                                            if (!"nickname".equals(str16) || !"link_plain".equals(str17)) {
                                                str4 = str14;
                                            } else {
                                                str4 = nullAsNil(map.get(str3 + ".plain")).toString();
                                            }
                                            i2++;
                                            str14 = str4;
                                        }
                                    }
                                }
                            }
                            if (z) {
                                if (safeParseInt == 1) {
                                    gs gsVar = new gs();
                                    gsVar.uu(nullAs);
                                    gsVar.uv(str2);
                                    gsVar.eKO = 1;
                                    gsVar.eKP = 1;
                                    gsVar.eKQ = 3;
                                    gsVar.bfK();
                                } else if (safeParseInt == 0) {
                                    gs gsVar2 = new gs();
                                    gsVar2.uu(nullAs);
                                    gsVar2.uv(str2);
                                    gsVar2.eKO = 1;
                                    gsVar2.eKP = 1;
                                    gsVar2.eKQ = 2;
                                    gsVar2.bfK();
                                }
                                showSwitchContactDialog(weakReference.get(), nullAs, concactSpannable(arrayList).toString(), str6, str8, str9, str14, str13, str2, str10, str11, str12);
                                AppMethodBeat.o(90722);
                                return;
                            } else if (isFirstSwitchContactTips(str6, str2)) {
                                markFirstSwitchContactTips(str6, str2);
                                gs gsVar3 = new gs();
                                gsVar3.uu(nullAs);
                                gsVar3.uv(str2);
                                gsVar3.eKO = 1;
                                gsVar3.eKP = 1;
                                gsVar3.eKQ = 1;
                                gsVar3.bfK();
                                showSwitchContactDialog(weakReference.get(), nullAs, concactSpannable(arrayList).toString(), str6, str8, str9, str14, str13, str2, str10, str11, str12);
                            }
                        }
                    } else {
                        startChattingUI(str6);
                        AppMethodBeat.o(90722);
                        return;
                    }
                }
            }
            AppMethodBeat.o(90722);
        } catch (Throwable th) {
            AppMethodBeat.o(90722);
        }
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(90723);
        alias(com.tencent.mm.plugin.messenger.a.c.class);
        AppMethodBeat.o(90723);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(90724);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        AppMethodBeat.o(90724);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(90725);
        if (gVar.aBb()) {
            g.aAi();
            g.b(b.class, this.zoF);
            g.b(e.class, this.zoG);
            y.at("selectrecord", "selectrecord", 3);
        }
        AppMethodBeat.o(90725);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(90726);
        if (gVar.aBb()) {
            pin(com.tencent.mm.plugin.w.a.eMS());
        }
        AppMethodBeat.o(90726);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-messenger";
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(90727);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("sysmsgtemplate", this.zoG.zqJ);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.zoI);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.zoJ);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.zoK);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_live", this.zoV);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("comment_link_profile", this.zoW);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.zoX);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.zoL);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.zoM);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.zoN);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.zoO);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.zoP);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.zoQ);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("new_link_succeed_contact", this.zoR);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", this.zoP);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.zoS);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_history", this.zoT);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).a(this.UYH);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("secmsg", this.zoU);
        g.azz().a(JsApiGetRecentUsageList.CTRL_INDEX, this);
        com.tencent.mm.plugin.messenger.d.d dVar = this.zoH;
        dVar.zqQ = new com.tencent.mm.plugin.messenger.e.a();
        dVar.zqR = new com.tencent.mm.plugin.messenger.e.c();
        dVar.zqS = new com.tencent.mm.plugin.messenger.e.b();
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(259555);
                int eiE = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSP().eiE();
                int eiF = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSP().eiF();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20460, Integer.valueOf(eiE), Integer.valueOf(eiF));
                AppMethodBeat.o(259555);
            }
        }, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(90727);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(90728);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("sysmsgtemplate", this.zoG.zqJ);
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_plain");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_succeed_contact");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_jump_chat");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_live");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("comment_link_profile");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_url");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_plain");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_succeed_contact");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_jump_chat");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke_qrcode");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_profile");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("new_link_succeed_contact");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke_unbindapp");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_url");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_history");
        ((com.tencent.mm.plugin.messenger.a.e) g.af(com.tencent.mm.plugin.messenger.a.e.class)).b(this.UYH);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("secmsg", this.zoU);
        g.azz().b(JsApiGetRecentUsageList.CTRL_INDEX, this);
        com.tencent.mm.plugin.messenger.d.d dVar = this.zoH;
        if (dVar.zqQ != null) {
            dVar.zqQ.release();
        }
        if (dVar.zqR != null) {
            dVar.zqR.release();
        }
        if (dVar.zqS != null) {
            dVar.zqS.release();
        }
        AppMethodBeat.o(90728);
    }

    public static String getAccSelectRecordPath() {
        AppMethodBeat.i(194474);
        if (!com.tencent.mm.vfs.s.YS("wcf://selectrecord/")) {
            com.tencent.mm.vfs.s.boN("wcf://selectrecord/");
        }
        AppMethodBeat.o(194474);
        return "wcf://selectrecord/";
    }

    private CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.i(90729);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(90729);
            return spannableString;
        }
        AppMethodBeat.o(90729);
        return charSequence;
    }

    private CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.i(90730);
        CharSequence spannableString = new SpannableString("");
        if (arrayList == null) {
            AppMethodBeat.o(90730);
            return spannableString;
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            spannableString = TextUtils.concat(spannableString, it.next());
        }
        AppMethodBeat.o(90730);
        return spannableString;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(90731);
        try {
            if (CrashReportFactory.hasDebuger()) {
                u.makeText(MMApplicationContext.getContext(), String.format("errType %s errCode %s errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str), 1).show();
            }
            if (qVar.getType() == 853) {
                if (this.gtM != null) {
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                if (qVar.equals(this.zoE)) {
                    q qVar2 = (q) qVar;
                    if (i3 == 0) {
                        saveSwitchContact(qVar2.jGZ, qVar2.jHj);
                        startChattingUI(qVar2.jGZ);
                    }
                    Log.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + i3 + " errType: " + i2 + " userName: " + qVar2.jGZ + " ticket: " + qVar2.jHi + " talkerUsername: " + qVar2.jHj);
                }
            }
            AppMethodBeat.o(90731);
        } catch (Throwable th) {
            Log.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(th)));
            AppMethodBeat.o(90731);
        }
    }

    private void startChattingUI(String str) {
        AppMethodBeat.i(90732);
        Log.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("Chat_Mode", 1);
        com.tencent.mm.br.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(90732);
    }

    public void showSwitchContactDialog(final Context context, final String str, String str2, final String str3, final String str4, final String str5, String str6, String str7, final String str8, String str9, String str10, String str11) {
        AppMethodBeat.i(90733);
        f.a aVar = new f.a(context);
        SwitchContactDialogCustomView switchContactDialogCustomView = new SwitchContactDialogCustomView(context);
        if (Util.isNullOrNil(str9)) {
            switchContactDialogCustomView.setTilte(context.getString(R.string.fj8));
        } else {
            switchContactDialogCustomView.setTilte(str9);
        }
        switchContactDialogCustomView.setContent(str2);
        switchContactDialogCustomView.setDesc(str6);
        switchContactDialogCustomView.setSubDesc("@".concat(String.valueOf(str7)));
        switchContactDialogCustomView.setPhoto(str3);
        switchContactDialogCustomView.setOnPhotoOnClick(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(259556);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/messenger/PluginMessenger$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str3);
                intent.putExtra(e.d.OyT, str5);
                com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(259556);
            }
        });
        if (Util.isNullOrNil(str10)) {
            str10 = context.getString(R.string.fj5);
        }
        if (Util.isNullOrNil(str11)) {
            str11 = context.getString(R.string.fj7);
        }
        aVar.hu(switchContactDialogCustomView).boA(str11).boB(str10).a(new f.c() {
            /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass13 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(194472);
                gs gsVar = new gs();
                gsVar.uu(str);
                gsVar.uv(str8);
                gsVar.eKO = 1;
                gsVar.eKP = 1;
                gsVar.eKR = 1;
                gsVar.bfK();
                AppMethodBeat.o(194472);
            }
        }, new f.c() {
            /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass21 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(259558);
                if (z && as.bjp(str3)) {
                    gs gsVar = new gs();
                    gsVar.uu(str);
                    gsVar.eKO = 1;
                    gsVar.uv(str8);
                    gsVar.eKP = 1;
                    gsVar.eKR = 2;
                    gsVar.bfK();
                    PluginMessenger.this.zoE = new q(str3, str4, 0);
                    PluginMessenger.this.zoE.jHj = str8;
                    g.azz().a(PluginMessenger.this.zoE, 0);
                    PluginMessenger pluginMessenger = PluginMessenger.this;
                    Context context = context;
                    context.getString(R.string.zb);
                    pluginMessenger.gtM = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.fj9), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.messenger.PluginMessenger.AnonymousClass21.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(259557);
                            g.azz().a(PluginMessenger.this.zoE);
                            AppMethodBeat.o(259557);
                        }
                    });
                }
                AppMethodBeat.o(259558);
            }
        }).show();
        AppMethodBeat.o(90733);
    }

    private String getFirstSwitchContactTipsPrefsKey(String str, String str2) {
        AppMethodBeat.i(90734);
        String str3 = "FirstSwitchContactTips_" + str + "_" + str2 + "_" + ((String) g.aAh().azQ().get(2, ""));
        AppMethodBeat.o(90734);
        return str3;
    }

    public void markFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.i(90735);
        MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), false).commit();
        AppMethodBeat.o(90735);
    }

    public boolean isFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.i(90736);
        boolean z = MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), true);
        AppMethodBeat.o(90736);
        return z;
    }

    private String getSwitchContactPrefsKey(String str, String str2) {
        AppMethodBeat.i(90737);
        String str3 = "switch_contact_prefs_" + str + "_" + str2 + "_" + ((String) g.aAh().azQ().get(2, ""));
        AppMethodBeat.o(90737);
        return str3;
    }

    private void saveSwitchContact(String str, String str2) {
        AppMethodBeat.i(90738);
        MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(str, str2), true).commit();
        AppMethodBeat.o(90738);
    }

    private boolean isSwitchContact(String str, String str2) {
        AppMethodBeat.i(90739);
        boolean z = MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(str, str2), false);
        AppMethodBeat.o(90739);
        return z;
    }
}
