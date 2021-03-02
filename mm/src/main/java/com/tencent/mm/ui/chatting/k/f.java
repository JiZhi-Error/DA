package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.a.c;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    int PEu = 0;
    int gCo = -1;
    private int tkX = 0;

    public f(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final int getType() {
        return 3;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final void gRY() {
        AppMethodBeat.i(36558);
        this.PEm.gSc();
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.f.AnonymousClass1 */
            final /* synthetic */ boolean qoy = true;

            public final void run() {
                ah ahVar;
                k.b HD;
                boolean z;
                AppMethodBeat.i(36551);
                LinkedList linkedList = new LinkedList();
                bg.aVF();
                Cursor ez = c.aSQ().ez(f.this.gAn, f.this.gCo);
                if (ez == null) {
                    Log.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(36551);
                    return;
                }
                if (ab.Eq(f.this.gAn)) {
                    bg.aVF();
                    ahVar = c.aSX().Kd(f.this.gAn);
                } else {
                    ahVar = null;
                }
                long j2 = 0;
                while (ez.moveToNext()) {
                    try {
                        ca caVar = new ca();
                        caVar.convertFrom(ez);
                        String str = caVar.field_content;
                        if (!(str == null || (HD = k.b.HD(str)) == null)) {
                            if (3 == HD.type) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                                if (j2 != b2) {
                                    linkedList.add(new c.C2089c(caVar.field_createTime));
                                    f.this.PEu++;
                                }
                                String b3 = f.b(caVar, ab.Eq(f.this.gAn));
                                as Kn = ((l) g.af(l.class)).aSN().Kn(b3);
                                String str2 = "";
                                if (ahVar != null) {
                                    str2 = ahVar.getDisplayName(b3);
                                }
                                int asl = e.asl(HD.iwJ);
                                String appName = com.tencent.mm.plugin.fav.a.b.getAppName(f.this.mContext, HD.eag);
                                bg.aVF();
                                as Kn2 = com.tencent.mm.model.c.aSN().Kn(HD.eag);
                                if (Kn2 == null || !Kn2.field_username.equals(HD.eag)) {
                                    ay.a.iDq.a(HD.eag, "", null);
                                } else {
                                    appName = Kn2.arJ();
                                }
                                a aVar = new a(caVar.field_createTime, HD.type, HD.title, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str2);
                                aVar.source = Util.isNullOrNil(appName) ? HD.description : appName;
                                aVar.appId = HD.appId;
                                aVar.imagePath = caVar.field_imgPath;
                                aVar.iconRes = asl;
                                linkedList.add(aVar);
                                j2 = b2;
                            }
                        }
                    } catch (Throwable th) {
                        ez.close();
                        AppMethodBeat.o(36551);
                        throw th;
                    }
                }
                ez.close();
                f.this.mDataList.addAll(linkedList);
                f.this.PEo = f.this.mDataList;
                linkedList.clear();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.f.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(36550);
                        if (f.this.PEm != null) {
                            f.this.PEm.D(AnonymousClass1.this.qoy, f.this.mDataList.size());
                        }
                        AppMethodBeat.o(36550);
                    }
                });
                AppMethodBeat.o(36551);
            }
        });
        AppMethodBeat.o(36558);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String bmB() {
        AppMethodBeat.i(36559);
        String string = this.mContext.getString(R.string.gq);
        AppMethodBeat.o(36559);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String gSb() {
        AppMethodBeat.i(36560);
        String string = this.mContext.getString(R.string.gq);
        AppMethodBeat.o(36560);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final c.e gRZ() {
        AppMethodBeat.i(36561);
        AnonymousClass2 r0 = new c.e() {
            /* class com.tencent.mm.ui.chatting.k.f.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void a(View view, int i2, c.b bVar) {
                String str;
                int i3;
                AppMethodBeat.i(36554);
                if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view.getContext())) {
                    AppMethodBeat.o(36554);
                    return;
                }
                bg.aVF();
                ca Hb = com.tencent.mm.model.c.aSQ().Hb(bVar.msgId);
                k.b HD = k.b.HD(Hb.field_content);
                String R = q.R(HD.url, "message");
                String R2 = q.R(HD.iwH, "message");
                PackageInfo packageInfo = f.getPackageInfo(f.this.mContext, HD.appId);
                f fVar = f.this;
                if (packageInfo == null) {
                    str = null;
                } else {
                    str = packageInfo.versionName;
                }
                if (packageInfo == null) {
                    i3 = 0;
                } else {
                    i3 = packageInfo.versionCode;
                }
                fVar.a(R, R2, str, i3, HD.appId, Hb.field_msgId, Hb.field_msgSvrId, Hb);
                AppMethodBeat.o(36554);
            }

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void b(View view, int i2, final c.b bVar) {
                AppMethodBeat.i(36555);
                Log.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i2));
                new com.tencent.mm.ui.tools.l(view.getContext()).b(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.ui.chatting.k.f.AnonymousClass2.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(36552);
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.string.g5j));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.string.ay9));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.string.b06));
                        AppMethodBeat.o(36552);
                    }
                }, new o.g() {
                    /* class com.tencent.mm.ui.chatting.k.f.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(36553);
                        bg.aVF();
                        f.this.d(menuItem.getItemId(), com.tencent.mm.model.c.aSQ().Hb(bVar.msgId));
                        AppMethodBeat.o(36553);
                    }
                });
                AppMethodBeat.o(36555);
            }
        };
        AppMethodBeat.o(36561);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final RecyclerView.v N(ViewGroup viewGroup) {
        AppMethodBeat.i(36562);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c52, viewGroup, false));
        AppMethodBeat.o(36562);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final void a(c.a aVar, int i2) {
        AppMethodBeat.i(36563);
        b bVar = (b) aVar;
        a aVar2 = (a) amy(i2);
        bVar.timeTV.setText(m.h(this.mContext, aVar2.timestamp));
        Bitmap a2 = com.tencent.mm.av.q.bcR().a(aVar2.imagePath, com.tencent.mm.cb.a.getDensity(this.mContext), false);
        if ((a2 == null || a2.isRecycled()) && ((a2 = h.c(aVar2.appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext))) == null || a2.isRecycled())) {
            bVar.nnL.setImageResource(R.raw.app_attach_file_icon_webpage);
        } else {
            bVar.nnL.setImageBitmap(a2);
        }
        bVar.tln.setText(Util.nullAs(aVar2.source, ""));
        b.g(bVar.tln, this.PEn.Pmg);
        AppMethodBeat.o(36563);
    }

    class b extends c.a {
        TextView jBR;
        ImageView nnL;
        TextView tln;
        ImageView tlu;

        public b(View view) {
            super(view);
            AppMethodBeat.i(36557);
            this.nnL = (ImageView) view.findViewById(R.id.cc2);
            this.jBR = (TextView) view.findViewById(R.id.cbl);
            this.jBR.setVisibility(8);
            this.tln = (TextView) view.findViewById(R.id.cd0);
            this.tlu = (ImageView) view.findViewById(R.id.cc7);
            this.tlu.setImageResource(R.drawable.am5);
            this.tlu.setVisibility(0);
            AppMethodBeat.o(36557);
        }
    }

    class a extends c.b {
        public String appId;
        public int iconRes;
        public String imagePath;
        public String source;

        public a(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5) {
            super(j2, i2, str, j3, str2, str3, str4, str5);
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            AppMethodBeat.i(36556);
            if (str != null) {
                String lowerCase = str.toLowerCase();
                if (!bmD(lowerCase)) {
                    if (!Util.isNullOrNil(this.source) && ng(lowerCase, this.source.toLowerCase())) {
                        AppMethodBeat.o(36556);
                        return true;
                    }
                } else if (!Util.isNullOrNil(this.source) && this.source.toLowerCase().contains(lowerCase)) {
                    AppMethodBeat.o(36556);
                    return true;
                }
                boolean bmC = super.bmC(lowerCase);
                AppMethodBeat.o(36556);
                return bmC;
            }
            AppMethodBeat.o(36556);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3, int i2, String str4, long j2, long j3, ca caVar) {
        AppMethodBeat.i(36564);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            Log.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            AppMethodBeat.o(36564);
            return;
        }
        if (!NetStatusUtil.isMobile(this.mContext) ? str == null || str.length() <= 0 : str2 != null && str2.length() > 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j2);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i2);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.gAn);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j3));
        intent.putExtra("KAppId", str4);
        String b2 = b(caVar, ab.Eq(this.gAn));
        intent.putExtra("pre_username", b2);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j3));
        if (caVar != null) {
            intent.putExtra("preUsername", b2);
        }
        intent.putExtra("preChatName", this.gAn);
        intent.putExtra("preChatTYPE", ac.aJ(b2, this.gAn));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.br.c.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(36564);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(36565);
        if (str == null || str.length() == 0) {
            str2 = null;
        } else {
            com.tencent.mm.pluginsdk.model.app.g o = h.o(str, true, false);
            str2 = o == null ? null : o.field_packageName;
        }
        if (str2 == null) {
            AppMethodBeat.o(36565);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                AppMethodBeat.o(36565);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e2, "", new Object[0]);
                AppMethodBeat.o(36565);
            }
        }
        return packageInfo;
    }
}
