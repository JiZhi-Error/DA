package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.mv.a.m;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSaveDraftUIC;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(33)
@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\u0018\u0010\u001e\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 \u0018\u00010\u001fH\u0016J\"\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u0017H\u0016J\u0012\u0010(\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0017H\u0014J\b\u0010,\u001a\u00020\u0017H\u0014J\b\u0010-\u001a\u00020\u0017H\u0014J=\u0010.\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u00062!\u0010/\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u001700H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "()V", "captureOutputPath", "", "forceHideFloatBallWhenDestroy", "", "isFinderNew", "originCoverPath", "postData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getPostData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setPostData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "requestForRequest", "selfFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfFinderContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setSelfFinderContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "chooseCover", "", "cropCover", "path", "doPost", "needCreateFinderContact", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "processPostData", "processor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updateCoverImg", "srcImgPath", "updateFinderContact", "updateWhenNotFinderUser", "Companion", "plugin-mv_release"})
public final class MusicMvPostUI extends BaseMusicMvUI {
    public static final a Ars = new a((byte) 0);
    csp Arp;
    private com.tencent.mm.plugin.finder.api.g Arq;
    private String Arr;
    private String UZM;
    private boolean UZN;
    private boolean UZO;
    private boolean UZP;
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(256930);
        AppMethodBeat.o(256930);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(256934);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(256934);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(256933);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(256933);
        return view;
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<csp, x> {
        final /* synthetic */ MusicMvPostUI Art;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MusicMvPostUI musicMvPostUI) {
            super(1);
            this.Art = musicMvPostUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(csp csp) {
            long j2;
            String str;
            FinderContact finderContact;
            FinderObject finderObject;
            LinkedList<FinderMedia> linkedList;
            FinderMedia first;
            AppMethodBeat.i(256915);
            csp csp2 = csp;
            p.h(csp2, LocaleUtil.ITALIAN);
            if (csp2.localId > 0) {
                com.tencent.mm.plugin.finder.storage.h hVar = com.tencent.mm.plugin.finder.storage.h.vDp;
                com.tencent.mm.plugin.finder.storage.h.Fx(csp2.localId);
            }
            g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g gVar = com.tencent.mm.plugin.finder.upload.g.vSH;
            p.h(csp2, "musicData");
            FinderObject finderObject2 = csp2.MxE;
            LinkedList<FinderObject> linkedList2 = csp2.LDi;
            String str2 = csp2.MxF;
            FinderObjectDesc finderObjectDesc = finderObject2 != null ? finderObject2.objectDesc : null;
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            bal bal = new bal();
            if (finderObject2 == null || finderObjectDesc == null) {
                j2 = -1;
            } else {
                FinderObject finderObject3 = csp2.MxE;
                if (finderObject3 != null) {
                    finderObject3.id = 0;
                }
                LinkedList<cjl> linkedList3 = new LinkedList<>();
                String str3 = str2;
                if (!(str3 == null || str3.length() == 0)) {
                    FinderMedia finderMedia = new FinderMedia();
                    finderMedia.url = str2;
                    finderMedia.thumbUrl = str2;
                    finderMedia.mediaType = 2;
                    finderObjectDesc.media.add(finderMedia);
                    linkedList3.add(com.tencent.mm.plugin.finder.storage.data.j.a(finderMedia));
                }
                finderObject2.objectType = 2;
                y yVar = y.vXH;
                finderObject2.createtime = y.dCA();
                if (asG != null) {
                    finderContact = com.tencent.mm.plugin.finder.api.b.a(asG);
                    finderObject = finderObject2;
                } else {
                    FinderContact finderContact2 = new FinderContact();
                    finderContact2.username = z.aUg();
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, "");
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(256915);
                        throw tVar;
                    }
                    finderContact2.nickname = (String) obj;
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    Object obj2 = aAh2.azQ().get(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, "");
                    if (obj2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(256915);
                        throw tVar2;
                    }
                    finderContact2.headUrl = (String) obj2;
                    if (asG == null || (str = asG.field_signature) == null) {
                        str = "";
                    }
                    finderContact2.signature = str;
                    com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    Object obj3 = aAh3.azQ().get(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, "");
                    if (obj3 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(256915);
                        throw tVar3;
                    }
                    finderContact2.coverImgUrl = (String) obj3;
                    finderContact = finderContact2;
                    finderObject = finderObject2;
                }
                finderObject.contact = finderContact;
                y yVar2 = y.vXH;
                if (y.dnv()) {
                    finderObject2.permissionFlag = 3;
                }
                FinderItem finderItem = new FinderItem();
                finderItem.updateFinderObject(finderObject2);
                finderItem.field_clipList = new cjh();
                p.g(linkedList2, "clipFinderObjects");
                for (T t : linkedList2) {
                    if (t != null) {
                        FinderObjectDesc finderObjectDesc2 = t.objectDesc;
                        if (!(finderObjectDesc2 == null || (linkedList = finderObjectDesc2.media) == null || (first = linkedList.getFirst()) == null)) {
                            first.mediaType = 4;
                        }
                        FinderObjectDesc finderObjectDesc3 = t.objectDesc;
                        if (finderObjectDesc3 != null) {
                            finderObjectDesc3.mediaType = 4;
                        }
                        FinderItem.a aVar3 = FinderItem.Companion;
                        FinderItem a2 = FinderItem.a.a((FinderObject) t, 0);
                        a2.setCreateTime(finderObject2.createtime);
                        LinkedList<aud> linkedList4 = finderItem.field_clipList.MoH;
                        FinderItem.a aVar4 = FinderItem.Companion;
                        linkedList4.add(FinderItem.a.l(a2));
                    }
                }
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                finderItem.field_reportObject = com.tencent.mm.plugin.finder.report.i.dnY();
                FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
                if (finderFeedReportObject != null) {
                    finderFeedReportObject.sendOrExitButtonTime = cl.aWA();
                    finderFeedReportObject.videoPostType = 2;
                    finderFeedReportObject.postStage = 1;
                }
                FinderFeedReportObject finderFeedReportObject2 = finderItem.field_reportObject;
                if (finderFeedReportObject2 != null) {
                    String str4 = finderObjectDesc.description;
                    finderFeedReportObject2.descCount = str4 != null ? str4.length() : 0;
                    finderFeedReportObject2.existDesc = finderItem.field_reportObject.descCount > 0 ? 1 : 0;
                }
                com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                bal.dTj = dHP.first.floatValue();
                bal.latitude = dHP.second.floatValue();
                com.tencent.mm.plugin.finder.upload.i iVar2 = com.tencent.mm.plugin.finder.upload.i.vSX;
                cjm dBh = com.tencent.mm.plugin.finder.upload.i.dBh();
                dBh.Mpd = cl.aWy();
                LinkedList<cjj> linkedList5 = dBh.Mpg;
                if (linkedList5 != null) {
                    dBh.Mpg.clear();
                    dBh.Mpg.addAll(linkedList5);
                }
                finderItem.setPostInfo(dBh);
                finderItem.setMediaExtList(linkedList3);
                finderItem.setPostWaiting();
                j2 = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().k(finderItem);
                Log.i(gVar.TAG, "MV insertNewFeed " + j2 + " localId:" + j2);
                finderItem.setLocalId(j2);
                gVar.FZ(j2);
                gVar.dAZ();
                r.d dVar = r.d.vhx;
                r.d.oa(finderItem.isLongVideo());
                com.tencent.mm.plugin.vlog.report.a aVar6 = com.tencent.mm.plugin.vlog.report.a.GDl;
                com.tencent.mm.plugin.vlog.report.a.fCu();
                finderItem.trackPost("doMvPost");
            }
            csp2.localId = j2;
            StringBuilder append = new StringBuilder("postData localId").append(csp2.localId).append(" coverLocalPath:");
            csp csp3 = this.Art.Arp;
            Log.i("MicroMsg.Mv.MusicMvPostUI", append.append(csp3 != null ? csp3.MxF : null).toString());
            Intent intent = new Intent(this.Art, MusicMvRouterUI.class);
            intent.addFlags(67108864);
            intent.putExtra("KEY_MUSIC_ROUTER", 5);
            intent.putExtra("key_track_data", csp2.toByteArray());
            intent.putExtra("key_seek_to_start", true);
            this.Art.overridePendingTransition(-1, R.anim.er);
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.sm(true);
            com.tencent.mm.plugin.music.model.c cVar2 = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.cjj();
            MusicMvPostUI musicMvPostUI = this.Art;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(musicMvPostUI, bl.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$doPost$1", "invoke", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            musicMvPostUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(musicMvPostUI, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$doPost$1", "invoke", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Art.finish();
            this.Art.UZO = true;
            com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
            boolean z = this.Art.UZP;
            String e2 = m.e(csp2);
            p.h(e2, "partList");
            on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
            hWv.bvI(e2);
            hWv.PX(z ? 1 : 0);
            hWv.PV(8);
            hWv.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(hWv);
            com.tencent.mm.plugin.mv.a.l lVar2 = com.tencent.mm.plugin.mv.a.l.UZs;
            long j3 = csp2.localId;
            on hWv2 = com.tencent.mm.plugin.mv.a.l.hWv();
            hWv2.PV(10);
            com.tencent.mm.plugin.mv.a.l.UZq.put(Long.valueOf(j3), hWv2);
            x xVar = x.SXb;
            AppMethodBeat.o(256915);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MusicMvPostUI$Companion;", "", "()V", "MENU_ID_FROM_ALBUM", "", "MENU_ID_FROM_CAMERA", "REQUEST_CODE_CREATE_FINDER_POST", "REQUEST_CODE_CROP_COVER", "REQUEST_CODE_SELECT_COVER_FROM_ALBUM", "REQUEST_CODE_SELECT_COVER_FROM_SIGHT", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(MusicMvPostUI musicMvPostUI) {
        AppMethodBeat.i(256931);
        musicMvPostUI.sq(true);
        AppMethodBeat.o(256931);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0096, code lost:
        if (r0 == null) goto L_0x0098;
     */
    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 485
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.MusicMvPostUI.onCreate(android.os.Bundle):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ MusicMvPostUI Art;

        g(MusicMvPostUI musicMvPostUI) {
            this.Art = musicMvPostUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(256917);
            MusicMvPostUI musicMvPostUI = this.Art;
            String aUg = z.aUg();
            musicMvPostUI.UZP = aUg == null || aUg.length() == 0;
            MusicMvPostUI.a(this.Art);
            AppMethodBeat.o(256917);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ MusicMvPostUI Art;

        h(MusicMvPostUI musicMvPostUI) {
            this.Art = musicMvPostUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(256918);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvSaveDraftUIC) com.tencent.mm.ui.component.a.b(this.Art).get(MusicMvSaveDraftUIC.class)).a(this.Art.Arp, true, 4);
            AppMethodBeat.o(256918);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r¸\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$6$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release", "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$$special$$inlined$let$lambda$1"})
    public static final class f implements com.tencent.mm.av.a.c.h {
        final /* synthetic */ MusicMvPostUI Art;
        final /* synthetic */ String Arv;
        final /* synthetic */ View Arw;

        f(String str, MusicMvPostUI musicMvPostUI, View view) {
            this.Arv = str;
            this.Art = musicMvPostUI;
            this.Arw = view;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            AppMethodBeat.i(256916);
            p.h(str, "url");
            if (bVar != null) {
                bitmap = bVar.bitmap;
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                if (bVar != null) {
                    bitmap2 = bVar.bitmap;
                }
                p.g(bitmap2, "imageData?.bitmap");
                if (!bitmap2.isRecycled()) {
                    byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    String messageDigest = com.tencent.xweb.util.d.getMessageDigest(bytes);
                    com.tencent.mm.plugin.comm.b bVar2 = com.tencent.mm.plugin.comm.b.qCp;
                    AppCompatActivity context = this.Art.getContext();
                    p.g(context, "context");
                    View view2 = this.Arw;
                    p.g(view2, "mvBlurBg");
                    Bitmap bitmap3 = bVar.bitmap;
                    p.g(bitmap3, "imageData.bitmap");
                    p.g(messageDigest, "md5Key");
                    com.tencent.mm.plugin.comm.b.a(context, view2, bitmap3, messageDigest);
                }
            }
            AppMethodBeat.o(256916);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            return null;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ MusicMvPostUI Art;

        i(MusicMvPostUI musicMvPostUI) {
            this.Art = musicMvPostUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(256919);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMvPostUI.b(this.Art);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256919);
        }
    }

    private final void evG() {
        AppMethodBeat.i(256922);
        if (this.Arq == null) {
            String aUg = z.aUg();
            if (!(aUg == null || aUg.length() == 0)) {
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                this.Arq = c.a.asG(z.aUg());
            }
        }
        AppMethodBeat.o(256922);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (r0 == null) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sq(boolean r5) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.MusicMvPostUI.sq(boolean):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$updateCoverImg$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
    public static final class j implements com.tencent.mm.av.a.c.h {
        final /* synthetic */ MusicMvPostUI Art;
        final /* synthetic */ View Arw;
        final /* synthetic */ String Arx;

        j(MusicMvPostUI musicMvPostUI, String str, View view) {
            this.Art = musicMvPostUI;
            this.Arx = str;
            this.Arw = view;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            Bitmap bitmap;
            Bitmap bitmap2 = null;
            AppMethodBeat.i(256920);
            p.h(str, "url");
            if (bVar != null) {
                bitmap = bVar.bitmap;
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                Bitmap bitmap3 = bVar != null ? bVar.bitmap : null;
                p.g(bitmap3, "imageData?.bitmap");
                if (!bitmap3.isRecycled()) {
                    byte[] bytes = str.getBytes(kotlin.n.d.UTF_8);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    String messageDigest = com.tencent.xweb.util.d.getMessageDigest(bytes);
                    com.tencent.mm.plugin.comm.b bVar2 = com.tencent.mm.plugin.comm.b.qCp;
                    AppCompatActivity context = this.Art.getContext();
                    p.g(context, "context");
                    AppCompatActivity appCompatActivity = context;
                    View view2 = this.Arw;
                    p.g(view2, "mvBlurBg");
                    if (bVar != null) {
                        bitmap2 = bVar.bitmap;
                    }
                    p.g(bitmap2, "imageData?.bitmap");
                    p.g(messageDigest, "md5Key");
                    com.tencent.mm.plugin.comm.b.a(appCompatActivity, view2, bitmap2, messageDigest);
                }
            }
            AppMethodBeat.o(256920);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            return null;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ MusicMvPostUI Art;

        b(MusicMvPostUI musicMvPostUI) {
            this.Art = musicMvPostUI;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(256912);
            AppCompatActivity context = this.Art.getContext();
            p.g(context, "context");
            mVar.d(1, context.getResources().getString(R.string.um));
            AppCompatActivity context2 = this.Art.getContext();
            p.g(context2, "context");
            mVar.d(2, context2.getResources().getString(R.string.f9k));
            AppMethodBeat.o(256912);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class c implements o.g {
        final /* synthetic */ MusicMvPostUI Art;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;

        c(MusicMvPostUI musicMvPostUI, com.tencent.mm.ui.widget.a.e eVar) {
            this.Art = musicMvPostUI;
            this.nkZ = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(256913);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    Intent intent = new Intent(this.Art, MusicMvRouterUI.class);
                    intent.putExtra("KEY_MUSIC_ROUTER", 2);
                    com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
                    com.tencent.mm.plugin.music.model.c.sm(true);
                    this.Art.UZN = true;
                    this.Art.startActivityForResult(intent, 1000);
                    AppMethodBeat.o(256913);
                    return;
                case 2:
                    com.tencent.mm.plugin.music.model.c cVar2 = com.tencent.mm.plugin.music.model.c.Akc;
                    com.tencent.mm.plugin.music.model.c.sm(true);
                    this.Art.UZN = true;
                    s.a(this.Art, 1001, 1, 27, 1, (Intent) null);
                    AppMethodBeat.o(256913);
                    return;
                default:
                    this.nkZ.bMo();
                    AppMethodBeat.o(256913);
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class d implements e.b {
        public static final d Aru = new d();

        static {
            AppMethodBeat.i(256914);
            AppMethodBeat.o(256914);
        }

        d() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    private final void aIn(String str) {
        AppMethodBeat.i(256924);
        Intent intent = new Intent();
        intent.putExtra("CropImageMode", 1);
        a aVar = a.ArA;
        intent.putExtra("CropImage_OutputPath", a.aIo(str));
        intent.putExtra("CropImage_ImgPath", str);
        intent.putExtra("CropImage_from_scene", 4);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        this.UZN = true;
        com.tencent.mm.plugin.setting.c.jRt.a(this, intent, 1003);
        AppMethodBeat.o(256924);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(256925);
        switch (i2) {
            case 1000:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("KEY_RECORD_PHOTO_PATH");
                    if (stringExtra == null) {
                        Log.w("MicroMsg.Mv.MusicMvPostUI", "capture null: ");
                        AppMethodBeat.o(256925);
                        return;
                    }
                    this.UZM = stringExtra;
                    aIn(stringExtra);
                    AppMethodBeat.o(256925);
                    return;
                }
            case 1001:
                if (intent != null && i3 == -1) {
                    String i4 = com.tencent.mm.ui.tools.a.i(getContext(), intent, com.tencent.mm.plugin.image.d.aSY());
                    if (i4 == null) {
                        Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: choose path null");
                        AppMethodBeat.o(256925);
                        return;
                    }
                    aIn(i4);
                    AppMethodBeat.o(256925);
                    return;
                }
            case 1002:
                Log.i("MicroMsg.Mv.MusicMvPostUI", "callback create finder contact post");
                sq(false);
                AppMethodBeat.o(256925);
                return;
            case 1003:
                if (intent != null) {
                    String stringExtra2 = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra2 != null) {
                        com.tencent.mm.vfs.s.deleteFile(this.UZM);
                        if (i3 != -1) {
                            com.tencent.mm.vfs.s.deleteFile(stringExtra2);
                            break;
                        } else {
                            com.tencent.mm.vfs.s.deleteFile(this.Arr);
                            this.Arr = stringExtra2;
                            csp csp = this.Arp;
                            if (csp != null) {
                                csp.MxF = stringExtra2;
                            }
                            View findViewById = findViewById(R.id.a_q);
                            ImageView imageView = (ImageView) findViewById(R.id.imb);
                            if (imageView != null) {
                                com.tencent.mm.av.a.a.c bdv = new c.a().bdo().bdr().bdv();
                                p.g(bdv, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
                                com.tencent.mm.av.q.bcV().a(stringExtra2, imageView, bdv, new j(this, stringExtra2, findViewById));
                                AppMethodBeat.o(256925);
                                return;
                            }
                            AppMethodBeat.o(256925);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.Mv.MusicMvPostUI", "onActivityResult: crop path null");
                        AppMethodBeat.o(256925);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(256925);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bei;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(256926);
        super.onResume();
        if (!this.UZN) {
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.onResume();
            AppMethodBeat.o(256926);
            return;
        }
        this.UZN = false;
        AppMethodBeat.o(256926);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(256927);
        super.onPause();
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.hWr();
        AppMethodBeat.o(256927);
    }

    @Override // com.tencent.mm.plugin.mv.ui.BaseMusicMvUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(256928);
        Set<Class<? extends UIComponent>> importUIComponents = super.importUIComponents();
        if (importUIComponents != null) {
            Set<Class<? extends UIComponent>> b2 = ak.b(importUIComponents, ak.setOf(MusicMvSaveDraftUIC.class));
            AppMethodBeat.o(256928);
            return b2;
        }
        AppMethodBeat.o(256928);
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(256929);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((MusicMvSaveDraftUIC) com.tencent.mm.ui.component.a.b(this).get(MusicMvSaveDraftUIC.class)).a(this.Arp, true, 4);
        AppMethodBeat.o(256929);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(259225);
        super.onDestroy();
        if (this.UZO) {
            com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
            com.tencent.mm.plugin.music.model.c.cjj();
        }
        AppMethodBeat.o(259225);
    }

    public static final /* synthetic */ void b(MusicMvPostUI musicMvPostUI) {
        AppMethodBeat.i(256932);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) musicMvPostUI, 1, false);
        AppCompatActivity context = musicMvPostUI.getContext();
        p.g(context, "context");
        eVar.setBackgroundColor(context.getResources().getColor(R.color.a1));
        eVar.hbr();
        eVar.a(new b(musicMvPostUI));
        eVar.a(new c(musicMvPostUI, eVar));
        eVar.b(d.Aru);
        eVar.dGm();
        AppMethodBeat.o(256932);
    }
}
