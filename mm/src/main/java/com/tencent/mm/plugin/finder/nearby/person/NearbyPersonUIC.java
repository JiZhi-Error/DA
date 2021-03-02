package com.tencent.mm.plugin.finder.nearby.person;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003&'(B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020%H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "adItemList", "", "", "Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "getAdItemList", "()Ljava/util/Map;", "sceneClearLocation", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "getSceneClearLocation", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;", "setSceneClearLocation", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsFind;)V", "sceneJoinLbsRoom", "Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "getSceneJoinLbsRoom", "()Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;", "setSceneJoinLbsRoom", "(Lcom/tencent/mm/plugin/nearby/model/NetSceneLbsRoom;)V", "sceneLbsFind", "getSceneLbsFind", "setSceneLbsFind", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "ADData", "Companion", "Location", "plugin-finder_release"})
public class NearbyPersonUIC extends UIComponent implements i {
    public static final b uRZ = new b((byte) 0);
    com.tencent.mm.plugin.nearby.a.c uRV;
    com.tencent.mm.plugin.nearby.a.c uRW;
    d uRX;
    final Map<String, a> uRY = new HashMap();

    static {
        AppMethodBeat.i(249264);
        AppMethodBeat.o(249264);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Companion;", "", "()V", "DO_NOT_DISPLAY_BIND_MOBILE_HEADER", "", "EARLY_GET_HEADIMG_THRESHOLD", "LBSROOM_CHATTING_REQ", "LBS_CONTACT_FINDER_FLAG_SHOW_ICON", "MENU_ID_ALL_PERSON", "MENU_ID_CANCEL", "MENU_ID_CLEAR_LOCATION_EXIT", "MENU_ID_NEARBY_SAY_HI", "MENU_ID_ONLY_FEMALE", "MENU_ID_ONLY_MALE", "MMSNS_FLAG_HAVE_OBJECT", "REQUEST_CODE_SAY_HI_UI", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyPersonUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249262);
        AppMethodBeat.o(249262);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyPersonUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249263);
        AppMethodBeat.o(249263);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(249261);
        p.h(qVar, "scene");
        AppMethodBeat.o(249261);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$Location;", "", "lat", "", "lng", "accuracy", "", "(FFI)V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getLat", "()F", "setLat", "(F)V", "getLng", "setLng", "plugin-finder_release"})
    public static final class c {
        int accuracy;
        float iUY;
        float iUZ;

        public c(float f2, float f3, int i2) {
            this.iUY = f2;
            this.iUZ = f3;
            this.accuracy = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData;", "", "()V", "closeCount", "", "getCloseCount", "()I", "setCloseCount", "(I)V", "closeTimes", "getCloseTimes", "setCloseTimes", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "getHide", "()Z", "setHide", "(Z)V", "icon", "getIcon", "setIcon", "id", "getId", "setId", "jumpVal", "getJumpVal", "setJumpVal", "jump_type", "getJump_type", "setJump_type", "name", "getName", "setName", "pos", "getPos", "setPos", "showCount", "getShowCount", "setShowCount", "showTimes", "getShowTimes", "setShowTimes", "stat", "getStat", "setStat", "Companion", "plugin-finder_release"})
    public static final class a {
        public static final C1244a uSg = new C1244a((byte) 0);
        String desc;
        String icon;
        String id;
        String name;
        boolean oBV;
        int pos;
        int qdp;
        int uSa;
        int uSb;
        int uSc;
        String uSd;
        int uSe;
        int uSf = -1;

        static {
            AppMethodBeat.i(249260);
            AppMethodBeat.o(249260);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonUIC$ADData$Companion;", "", "()V", "STAT_CLICK", "", "STAT_CLOSE", "STAT_VIEW", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.person.NearbyPersonUIC$a$a  reason: collision with other inner class name */
        public static final class C1244a {
            private C1244a() {
            }

            public /* synthetic */ C1244a(byte b2) {
                this();
            }
        }
    }
}
