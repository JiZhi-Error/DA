package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.e;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

public final class h extends b {
    HashSet<Integer> PEP = new HashSet<>();
    int PEu = 0;
    int gCo = -1;

    public h(Context context) {
        super(context);
        AppMethodBeat.i(36588);
        AppMethodBeat.o(36588);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final int getType() {
        AppMethodBeat.i(36589);
        this.PEP.add(5);
        this.PEP.add(7);
        this.PEP.add(27);
        this.PEP.add(26);
        this.PEP.add(15);
        this.PEP.add(51);
        this.PEP.add(63);
        AppMethodBeat.o(36589);
        return -1;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final void gRY() {
        AppMethodBeat.i(36590);
        this.PEm.gSc();
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass1 */
            final /* synthetic */ boolean qoy = true;

            public final void run() {
                ah ahVar;
                k.b HD;
                String str;
                boolean z;
                AppMethodBeat.i(36581);
                LinkedList linkedList = new LinkedList();
                bg.aVF();
                Cursor ez = com.tencent.mm.model.c.aSQ().ez(h.this.gAn, h.this.gCo);
                if (ez == null) {
                    Log.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(36581);
                    return;
                }
                if (ab.Eq(h.this.gAn)) {
                    bg.aVF();
                    ahVar = com.tencent.mm.model.c.aSX().Kd(h.this.gAn);
                } else {
                    ahVar = null;
                }
                long j2 = 0;
                while (ez.moveToNext()) {
                    try {
                        ca caVar = new ca();
                        caVar.convertFrom(ez);
                        String str2 = caVar.field_content;
                        if (!(str2 == null || (HD = k.b.HD(str2)) == null)) {
                            h hVar = h.this;
                            int i2 = HD.type;
                            hVar.getType();
                            if (hVar.PEP.contains(Integer.valueOf(i2))) {
                                long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                                if (j2 != b2) {
                                    linkedList.add(new c.C2089c(caVar.field_createTime));
                                    h.this.PEu++;
                                }
                                String b3 = h.b(caVar, ab.Eq(h.this.gAn));
                                as Kn = ((l) g.af(l.class)).aSN().Kn(b3);
                                String str3 = "";
                                if (ahVar != null) {
                                    str3 = ahVar.getDisplayName(b3);
                                }
                                int asl = e.asl(HD.iwJ);
                                String appName = com.tencent.mm.plugin.fav.a.b.getAppName(h.this.mContext, HD.eag);
                                bg.aVF();
                                as Kn2 = com.tencent.mm.model.c.aSN().Kn(HD.eag);
                                if (Kn2 == null || !Kn2.field_username.equals(HD.eag)) {
                                    ay.a.iDq.a(HD.eag, "", null);
                                } else {
                                    appName = Kn2.arJ();
                                }
                                a aVar = new a(caVar.field_createTime, HD.type, HD.title, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str3);
                                if (HD.type == 5) {
                                    Log.i("MicroMsg.UrlHistoryListPresenter", "alvinluo loadData type: %d", Integer.valueOf(HD.type));
                                    b bVar = new b();
                                    com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) HD.as(com.tencent.mm.ag.e.class);
                                    if (eVar != null && eVar.iwe == 1 && eVar.iwc == 5) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    bVar.PEU = z;
                                    aVar.PET = bVar;
                                }
                                if (Util.isNullOrNil(appName)) {
                                    str = HD.description;
                                } else {
                                    str = appName;
                                }
                                aVar.source = str;
                                aVar.appId = HD.appId;
                                if (Util.isNullOrNil(caVar.field_imgPath)) {
                                    aVar.imagePath = HD.thumburl;
                                } else {
                                    aVar.imagePath = caVar.field_imgPath;
                                }
                                aVar.iconRes = asl;
                                if (HD.type == 51) {
                                    f fVar = (f) HD.as(f.class);
                                    aVar.title = h.this.mContext.getString(R.string.dk0, fVar.jlg.nickname);
                                    if (fVar.jlg.mediaList.size() > 0) {
                                        aVar.imagePath = fVar.jlg.mediaList.getFirst().thumbUrl;
                                    } else {
                                        aVar.imagePath = "";
                                    }
                                }
                                linkedList.add(aVar);
                                if (linkedList.size() % 20 == 0) {
                                    if (h.this.mDataList.size() > 0 && ((c.b) h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646) {
                                        h.this.mDataList.remove(h.this.mDataList.size() - 1);
                                    }
                                    h.this.mDataList.addAll(linkedList);
                                    h.this.mDataList.add(new c.g());
                                    h.this.PEo = h.this.mDataList;
                                    linkedList.clear();
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(36580);
                                            if (h.this.PEm != null) {
                                                h.this.PEm.D(AnonymousClass1.this.qoy, h.this.mDataList.size());
                                            }
                                            AppMethodBeat.o(36580);
                                        }
                                    });
                                }
                                j2 = b2;
                            }
                        }
                    } catch (Throwable th) {
                        ez.close();
                        AppMethodBeat.o(36581);
                        throw th;
                    }
                }
                ez.close();
                if (h.this.mDataList.size() > 0 && ((c.b) h.this.mDataList.get(h.this.mDataList.size() - 1)).getType() == 2147483646) {
                    h.this.mDataList.remove(h.this.mDataList.size() - 1);
                }
                h.this.mDataList.addAll(linkedList);
                h.this.PEo = h.this.mDataList;
                linkedList.clear();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(233506);
                        if (h.this.PEm != null) {
                            h.this.PEm.D(AnonymousClass1.this.qoy, h.this.mDataList.size());
                        }
                        AppMethodBeat.o(233506);
                    }
                });
                AppMethodBeat.o(36581);
            }
        });
        AppMethodBeat.o(36590);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String bmB() {
        AppMethodBeat.i(36591);
        String string = this.mContext.getString(R.string.gr);
        AppMethodBeat.o(36591);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String gSb() {
        AppMethodBeat.i(36592);
        String string = this.mContext.getString(R.string.gr);
        AppMethodBeat.o(36592);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final c.e gRZ() {
        AppMethodBeat.i(36593);
        AnonymousClass2 r0 = new c.e() {
            /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void a(View view, int i2, c.b bVar) {
                AppMethodBeat.i(36584);
                Log.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i2));
                if (bVar == null) {
                    Log.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", Integer.valueOf(i2));
                    AppMethodBeat.o(36584);
                    return;
                }
                a aVar = (a) bVar;
                if (aVar.getType() == 5) {
                    h.a(h.this, view, aVar);
                    AppMethodBeat.o(36584);
                } else if (aVar.getType() == 7) {
                    h.a(h.this, aVar);
                    AppMethodBeat.o(36584);
                } else if (aVar.getType() == 15) {
                    h.b(h.this, aVar);
                    AppMethodBeat.o(36584);
                } else if (aVar.getType() == 26) {
                    h.c(h.this, aVar);
                    AppMethodBeat.o(36584);
                } else if (aVar.getType() == 27) {
                    h.d(h.this, aVar);
                    AppMethodBeat.o(36584);
                } else if (aVar.getType() != 51) {
                    Log.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", Integer.valueOf(aVar.getType()));
                    AppMethodBeat.o(36584);
                } else if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(h.this.mContext)) {
                    AppMethodBeat.o(36584);
                } else {
                    h.e(h.this, aVar);
                    AppMethodBeat.o(36584);
                }
            }

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void b(View view, final int i2, final c.b bVar) {
                AppMethodBeat.i(36585);
                Log.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i2));
                new com.tencent.mm.ui.tools.l(view.getContext()).b(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass2.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(36582);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.g5j));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.string.ay9));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.b06));
                        AppMethodBeat.o(36582);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.ui.chatting.k.h.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(36583);
                        if (bVar == null) {
                            Log.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", Integer.valueOf(i2));
                            AppMethodBeat.o(36583);
                            return;
                        }
                        bg.aVF();
                        h.this.d(i2, com.tencent.mm.model.c.aSQ().Hb(bVar.msgId));
                        AppMethodBeat.o(36583);
                    }
                });
                AppMethodBeat.o(36585);
            }
        };
        AppMethodBeat.o(36593);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final RecyclerView.v N(ViewGroup viewGroup) {
        AppMethodBeat.i(36594);
        c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c52, viewGroup, false));
        AppMethodBeat.o(36594);
        return cVar;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final void a(c.a aVar, int i2) {
        boolean z;
        int i3 = 0;
        AppMethodBeat.i(36595);
        c cVar = (c) aVar;
        a aVar2 = (a) amy(i2);
        if (Util.isNullOrNil(aVar2.desc) || !Util.isNullOrNil(aVar2.source)) {
            cVar.jBR.setVisibility(8);
        } else {
            cVar.jBR.setVisibility(0);
            cVar.jBR.setText(Util.nullAs(aVar2.desc, ""));
        }
        Bitmap a2 = q.bcR().a(aVar2.imagePath, com.tencent.mm.cb.a.getDensity(this.mContext), false);
        if (a2 == null || a2.isRecycled()) {
            Bitmap c2 = com.tencent.mm.pluginsdk.model.app.h.c(aVar2.appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
            if (aVar2.PET == null || !aVar2.PET.PEU) {
                z = false;
            } else {
                z = true;
            }
            String a3 = com.tencent.mm.api.b.a(aVar2.imagePath, 4, z);
            Log.v("MicroMsg.UrlHistoryListPresenter", "alvinluo fillDetail coverUrl: %s, isBizNativeVideo: %b", a3, Boolean.valueOf(z));
            if (c2 == null || c2.isRecycled()) {
                if (z) {
                    i3 = 4;
                }
                c.a aVar3 = new c.a();
                aVar3.jbq = R.color.j6;
                aVar3.jbe = true;
                aVar3.fullPath = s.bdu(a3);
                c.a dr = aVar3.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
                dr.jaU = new n(i3);
                dr.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(i3);
                dr.jbd = true;
                q.bcV().a(a3, cVar.nnL, aVar3.bdv());
                cVar.tln.setText(Util.nullAs(aVar2.source, ""));
                c.g(cVar.tln, this.PEn.Pmg);
                AppMethodBeat.o(36595);
            }
            a2 = c2;
        }
        cVar.nnL.setImageBitmap(a2);
        cVar.tln.setText(Util.nullAs(aVar2.source, ""));
        c.g(cVar.tln, this.PEn.Pmg);
        AppMethodBeat.o(36595);
    }

    class c extends c.a {
        TextView jBR;
        ImageView nnL;
        TextView tln;

        public c(View view) {
            super(view);
            AppMethodBeat.i(36587);
            this.nnL = (ImageView) view.findViewById(R.id.cc2);
            this.jBR = (TextView) view.findViewById(R.id.cbl);
            this.tln = (TextView) view.findViewById(R.id.cd0);
            this.tln.setVisibility(0);
            AppMethodBeat.o(36587);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends c.b {
        public b PET = null;
        public String appId;
        public String desc;
        public int iconRes;
        public String imagePath;
        public String source;

        public a(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5) {
            super(j2, i2, str, j3, str2, str3, str4, str5);
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            AppMethodBeat.i(36586);
            if (str != null) {
                String lowerCase = str.toLowerCase();
                if (!bmD(lowerCase)) {
                    if (!Util.isNullOrNil(this.source) && ng(lowerCase, this.source.toLowerCase())) {
                        AppMethodBeat.o(36586);
                        return true;
                    }
                } else if (!Util.isNullOrNil(this.source) && this.source.toLowerCase().contains(lowerCase)) {
                    AppMethodBeat.o(36586);
                    return true;
                }
                boolean bmC = super.bmC(lowerCase);
                AppMethodBeat.o(36586);
                return bmC;
            }
            AppMethodBeat.o(36586);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        public boolean PEU = false;

        b() {
        }
    }

    private static String bs(Context context, String str) {
        String str2;
        AppMethodBeat.i(36597);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                str2 = next.activityInfo.name;
                AppMethodBeat.o(36597);
                return str2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e2, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(36597);
        return str2;
    }

    private boolean a(ca caVar, com.tencent.mm.pluginsdk.model.app.g gVar) {
        int i2;
        AppMethodBeat.i(36596);
        if (!caVar.field_talker.endsWith("@qqim") || !gVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            AppMethodBeat.o(36596);
            return false;
        }
        Log.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.setClassName(TbsConfig.APP_QQ, bs(this.mContext, TbsConfig.APP_QQ));
        intent.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
        bg.aVF();
        Object obj = com.tencent.mm.model.c.azQ().get(9, (Object) null);
        if (obj == null || !(obj instanceof Integer)) {
            i2 = 0;
        } else {
            i2 = ((Integer) obj).intValue();
        }
        if (i2 != 0) {
            try {
                byte[] bytes = String.valueOf(i2).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    byte b2 = bytes2[i3];
                    if (i4 >= bytes.length) {
                        break;
                    }
                    bytes[i4] = (byte) (b2 ^ bytes[i4]);
                    i3++;
                    i4++;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e2, "", new Object[0]);
            }
        }
        try {
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } catch (Exception e3) {
        }
        AppMethodBeat.o(36596);
        return true;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(36598);
        if (str == null || str.length() == 0) {
            str2 = null;
        } else {
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
            str2 = o == null ? null : o.field_packageName;
        }
        if (str2 == null) {
            AppMethodBeat.o(36598);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                AppMethodBeat.o(36598);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e2, "", new Object[0]);
                AppMethodBeat.o(36598);
            }
        }
        return packageInfo;
    }

    static /* synthetic */ void a(h hVar, View view, a aVar) {
        boolean z;
        AppMethodBeat.i(36599);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.msgId);
        k.b HD = k.b.HD(Hb.field_content);
        if (aVar == null || aVar.PET == null || !aVar.PET.PEU || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
            z = false;
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(e.b.OyQ, 1);
            bundle.putInt(e.b.OyR, 10000);
            bundle.putInt("geta8key_scene", 1);
            bundle.putString("geta8key_username", hVar.gAn);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(view.getContext(), Hb.field_msgId, Hb.field_msgSvrId, 0, bundle);
            z = true;
        }
        if (!z && HD.url != null && !HD.url.equals("")) {
            String R = com.tencent.mm.pluginsdk.model.app.q.R(HD.url, ab.Eq(hVar.gAn) ? "groupmessage" : "singlemessage");
            String str = HD.url;
            PackageInfo packageInfo = getPackageInfo(hVar.mContext, HD.appId);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", R);
            intent.putExtra("webpageTitle", HD.title);
            if (HD.appId != null && ("wx751a1acca5688ba3".equals(HD.appId) || "wxfbc915ff7c30e335".equals(HD.appId) || "wx482a4001c37e2b74".equals(HD.appId))) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("jsapi_args_appid", HD.appId);
                intent.putExtra("jsapiargs", bundle2);
            }
            if (!Util.isNullOrNil(str)) {
                intent.putExtra("shortUrl", str);
            } else {
                intent.putExtra("shortUrl", HD.url);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!Util.isNullOrNil(HD.eag)) {
                intent.putExtra("srcUsername", HD.eag);
                intent.putExtra("srcDisplayname", HD.eah);
            }
            intent.putExtra("msg_id", Hb.field_msgId);
            intent.putExtra("key_enable_teen_mode_check", true);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(Hb.field_msgSvrId));
            intent.putExtra("KAppId", HD.appId);
            intent.putExtra("geta8key_username", hVar.gAn);
            String b2 = b(Hb, ab.Eq(hVar.gAn));
            intent.putExtra("pre_username", b2);
            intent.putExtra("prePublishId", "msg_" + Long.toString(Hb.field_msgSvrId));
            intent.putExtra("preUsername", b2);
            intent.putExtra("preChatName", hVar.gAn);
            intent.putExtra("preChatTYPE", ac.aJ(b2, hVar.gAn));
            intent.putExtra("preMsgIndex", 0);
            com.tencent.mm.br.c.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(36599);
    }

    static /* synthetic */ void a(h hVar, a aVar) {
        boolean z;
        AppMethodBeat.i(36600);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.msgId);
        k.b HD = k.b.HD(Hb.field_content);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false);
        if (o != null) {
            String str = hVar.gAn;
            if (ab.Eq(str)) {
                str = bp.Ks(Hb.field_content);
            }
            long j2 = Hb.field_msgSvrId;
            int i2 = (o == null || !com.tencent.mm.pluginsdk.model.app.q.s(hVar.mContext, o.field_packageName)) ? 6 : 3;
            if (HD.type == 2) {
                i2 = 4;
            } else if (HD.type == 5) {
                i2 = 1;
            }
            ry ryVar = new ry();
            ryVar.dYw.context = hVar.mContext;
            ryVar.dYw.scene = 1;
            ryVar.dYw.dNI = HD.appId;
            ryVar.dYw.packageName = o == null ? null : o.field_packageName;
            ryVar.dYw.msgType = HD.type;
            ryVar.dYw.dRL = str;
            ryVar.dYw.dYx = i2;
            ryVar.dYw.mediaTagName = HD.mediaTagName;
            ryVar.dYw.dTS = j2;
            ryVar.dYw.dYy = "";
            ryVar.dYw.dCw = hVar.gAn;
            EventCenter.instance.publish(ryVar);
            com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
            if (com.tencent.mm.pluginsdk.model.app.h.a(hVar.mContext, o) || dSQ == null) {
                z = false;
            } else {
                if (!Util.isNullOrNil(o.fmK)) {
                    boolean ck = r.ck(hVar.mContext, o.fmK);
                    Log.i("MicroMsg.UrlHistoryListPresenter", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", o.fmK, Boolean.valueOf(ck));
                    if (ck) {
                        z = true;
                    }
                }
                is isVar = new is();
                isVar.dNr.actionCode = 2;
                isVar.dNr.scene = 1;
                isVar.dNr.appId = o.field_appId;
                isVar.dNr.context = hVar.mContext;
                EventCenter.instance.publish(isVar);
                new Intent();
                dSQ.am(o.field_appId, 1, 1);
                z = true;
            }
            if (!z) {
                if (HD.dCK == null || HD.dCK.length() == 0) {
                    String str2 = Hb.field_content;
                    if (Hb.field_isSend == 0) {
                        int i3 = Hb.field_isSend;
                        if (ab.Eq(hVar.gAn) && str2 != null && i3 == 0) {
                            str2 = bp.Kt(str2);
                        }
                    }
                    k.b HD2 = k.b.HD(str2);
                    com.tencent.mm.pluginsdk.model.app.g o2 = com.tencent.mm.pluginsdk.model.app.h.o(HD2.appId, true, false);
                    if (o2 == null || !com.tencent.mm.pluginsdk.model.app.q.s(hVar.mContext, o2.field_packageName)) {
                        String R = com.tencent.mm.pluginsdk.model.app.q.R(hVar.mContext, HD2.appId, "message");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", R);
                        com.tencent.mm.br.c.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    } else if (o2.field_status == 3) {
                        Log.e("MicroMsg.UrlHistoryListPresenter", "requestAppShow fail, app is in blacklist, packageName = " + o2.field_packageName);
                        AppMethodBeat.o(36600);
                        return;
                    } else if (!com.tencent.mm.pluginsdk.model.app.q.b(hVar.mContext, o2)) {
                        Log.e("MicroMsg.UrlHistoryListPresenter", "The app %s signature is incorrect.", o2.field_appName);
                        Toast.makeText(hVar.mContext, hVar.mContext.getString(R.string.dpi, com.tencent.mm.pluginsdk.model.app.h.a(hVar.mContext, o2, (String) null)), 1).show();
                        AppMethodBeat.o(36600);
                        return;
                    } else if (!hVar.a(Hb, o2)) {
                        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = HD2.extInfo;
                        if (HD2.dCK != null && HD2.dCK.length() > 0) {
                            com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD2.dCK);
                            wXAppExtendObject.filePath = bdx == null ? null : bdx.field_fileFullPath;
                        }
                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                        wXMediaMessage.sdkVer = Build.SDK_INT;
                        wXMediaMessage.mediaObject = wXAppExtendObject;
                        wXMediaMessage.title = HD2.title;
                        wXMediaMessage.description = HD2.description;
                        wXMediaMessage.messageAction = HD2.messageAction;
                        wXMediaMessage.messageExt = HD2.messageExt;
                        wXMediaMessage.thumbData = com.tencent.mm.vfs.s.aW(q.bcR().Oz(Hb.field_imgPath), 0, -1);
                        new au(hVar.mContext).a(o2.field_packageName, wXMediaMessage, o2.field_appId, o2.field_openId);
                        AppMethodBeat.o(36600);
                        return;
                    }
                    AppMethodBeat.o(36600);
                    return;
                } else if (!hVar.gSk()) {
                    u.g(hVar.mContext, null);
                    AppMethodBeat.o(36600);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setClassName(hVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent2.putExtra("app_msg_id", Hb.field_msgId);
                    Context context = hVar.mContext;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "enterAppDataProfile", "(Lcom/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter$UrlMediaHistoryListItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter", "enterAppDataProfile", "(Lcom/tencent/mm/ui/chatting/presenter/UrlHistoryListPresenter$UrlMediaHistoryListItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            }
        }
        AppMethodBeat.o(36600);
    }

    static /* synthetic */ void b(h hVar, a aVar) {
        AppMethodBeat.i(36601);
        bg.aVF();
        k.b HD = k.b.HD(com.tencent.mm.model.c.aSQ().Hb(aVar.msgId).field_content);
        String str = HD.ixo;
        if (TextUtils.isEmpty(str)) {
            str = ((d) g.ah(d.class)).getEmojiMgr().ams(HD.url);
        }
        if (TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", z.aTY());
            intent.putExtra("rawUrl", HD.url);
            com.tencent.mm.br.c.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(36601);
            return;
        }
        Log.d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", str);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        com.tencent.mm.br.c.b(hVar.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10993, 2, str);
        AppMethodBeat.o(36601);
    }

    static /* synthetic */ void c(h hVar, a aVar) {
        AppMethodBeat.i(36602);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.msgId);
        k.b HD = k.b.HD(Hb.field_content);
        int i2 = HD.tid;
        String str = HD.iyW;
        String str2 = HD.desc;
        String str3 = HD.iconUrl;
        String str4 = HD.secondUrl;
        if (i2 != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b(Hb, ab.Eq(hVar.gAn)));
            intent.putExtra("rawUrl", HD.fQR);
            intent.putExtra("topic_id", i2);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            com.tencent.mm.br.c.b(hVar.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            AppMethodBeat.o(36602);
            return;
        }
        Log.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.o(36602);
    }

    static /* synthetic */ void d(h hVar, a aVar) {
        AppMethodBeat.i(36603);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.msgId);
        k.b HD = k.b.HD(Hb.field_content);
        int i2 = HD.tid;
        String str = HD.iyW;
        String str2 = HD.desc;
        String str3 = HD.iconUrl;
        String str4 = HD.secondUrl;
        int i3 = HD.pageType;
        if (i2 != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b(Hb, ab.Eq(hVar.gAn)));
            intent.putExtra("rawUrl", HD.fQR);
            intent.putExtra("set_id", i2);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i3);
            com.tencent.mm.br.c.b(hVar.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            AppMethodBeat.o(36603);
            return;
        }
        Log.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
        AppMethodBeat.o(36603);
    }

    static /* synthetic */ void e(h hVar, a aVar) {
        long j2;
        AppMethodBeat.i(163327);
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(aVar.msgId);
        f fVar = (f) k.b.HD(Hb.field_content).as(f.class);
        Intent intent = new Intent();
        if (ab.Eq(Hb.field_talker)) {
            intent.putExtra("report_scene", 2);
        } else {
            intent.putExtra("report_scene", 1);
        }
        intent.putExtra("from_user", Hb.field_talker);
        String str = fVar.jlg.objectId;
        if (str == null || str.isEmpty()) {
            j2 = 0;
        } else {
            j2 = new BigInteger(str).longValue();
        }
        intent.putExtra("feed_object_id", j2);
        intent.putExtra("feed_object_nonceId", fVar.jlg.objectNonceId);
        intent.putExtra("business_type", 0);
        intent.putExtra("finder_user_name", fVar.jlg.username);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(6, 2, 25, intent);
        ((aj) g.ah(aj.class)).enterFinderShareFeedUI(hVar.mContext, intent);
        AppMethodBeat.o(163327);
    }
}
