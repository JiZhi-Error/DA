package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00118VX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00118VX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\n0\n8VX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001d\u0010\r¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fromUser", "", "kotlin.jvm.PlatformType", "getFromUser", "()Ljava/lang/String;", "fromUser$delegate", "Lkotlin/Lazy;", "hasFinderEntry", "", "getHasFinderEntry", "()Z", "isSelf", "isSelf$delegate", "isSelfFlag", "isSelfFlag$delegate", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getProfileContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", ch.COL_USERNAME, "getUsername", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public class FinderProfileFragmentUIC extends UIComponent {
    private final f tZk = g.ah(new d(this));
    private final f tZl = g.ah(new c(this));
    private final bbn ttO;
    private final f vag = g.ah(new b(this));
    private final boolean vah = ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry();
    private final f vbh = g.ah(new a(this));

    public String getFromUser() {
        AppMethodBeat.i(250261);
        String str = (String) this.vbh.getValue();
        AppMethodBeat.o(250261);
        return str;
    }

    public String getUsername() {
        AppMethodBeat.i(250257);
        String str = (String) this.tZk.getValue();
        AppMethodBeat.o(250257);
        return str;
    }

    public boolean isSelf() {
        AppMethodBeat.i(250259);
        boolean booleanValue = ((Boolean) this.vag.getValue()).booleanValue();
        AppMethodBeat.o(250259);
        return booleanValue;
    }

    public boolean isSelfFlag() {
        AppMethodBeat.i(250258);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(250258);
        return booleanValue;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileFragmentUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(250263);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        this.ttO = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).dIx();
        AppMethodBeat.o(250263);
    }

    public com.tencent.mm.plugin.finder.api.g getProfileContact() {
        AppMethodBeat.i(250260);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(getUsername());
        AppMethodBeat.o(250260);
        return asG;
    }

    public boolean getHasFinderEntry() {
        return this.vah;
    }

    public bbn getContextObj() {
        return this.ttO;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(250262);
        super.onCreate(bundle);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int i2 = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).wyZ;
        if (i2 == 1 || i2 == 2 || i2 == 14 || i2 == 15) {
            e.INSTANCE.idkeyStat(1278, 15, 1, false);
            k kVar = k.vfA;
            String fromUser = getFromUser();
            if (fromUser == null) {
                fromUser = "";
            }
            String username = getUsername();
            p.g(username, ch.COL_USERNAME);
            k.x(i2, fromUser, username);
        }
        AppMethodBeat.o(250262);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderProfileFragmentUIC vbi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileFragmentUIC finderProfileFragmentUIC) {
            super(0);
            this.vbi = finderProfileFragmentUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(250256);
            String stringExtra = this.vbi.getActivity().getIntent().getStringExtra("finder_username");
            AppMethodBeat.o(250256);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileFragmentUIC vbi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileFragmentUIC finderProfileFragmentUIC) {
            super(0);
            this.vbi = finderProfileFragmentUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250255);
            Boolean valueOf = Boolean.valueOf(this.vbi.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250255);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileFragmentUIC vbi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderProfileFragmentUIC finderProfileFragmentUIC) {
            super(0);
            this.vbi = finderProfileFragmentUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250254);
            Boolean valueOf = Boolean.valueOf(p.j(this.vbi.getUsername(), z.aUg()));
            AppMethodBeat.o(250254);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderProfileFragmentUIC vbi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderProfileFragmentUIC finderProfileFragmentUIC) {
            super(0);
            this.vbi = finderProfileFragmentUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(250253);
            String stringExtra = this.vbi.getIntent().getStringExtra("from_user");
            AppMethodBeat.o(250253);
            return stringExtra;
        }
    }
}
