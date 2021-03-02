package com.tencent.mm.plugin.festival.ui.bak;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalBakUIComponentFactory;", "", "()V", "INTENT_KEY_UICOMPONENT_TYPE", "", "getUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "intent", "Landroid/content/Intent;", "UIComponentType", "plugin-festival_release"})
public final class a {
    public static final a UEx = new a();

    static {
        AppMethodBeat.i(263339);
        AppMethodBeat.o(263339);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\f¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalBakUIComponentFactory$UIComponentType;", "", "uicClazz", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "(Ljava/lang/String;ILjava/lang/Class;)V", "getUicClazz", "()Ljava/lang/Class;", "fillIntent", "", "intent", "Landroid/content/Intent;", "WaitForHeartbeatLoading", "Companion", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.ui.bak.a$a  reason: collision with other inner class name */
    public enum EnumC1072a {
        WaitForHeartbeatLoading;
        
        public static final C1073a UEB = new C1073a((byte) 0);
        final Class<? extends UIComponent> UEA;

        public static EnumC1072a valueOf(String str) {
            AppMethodBeat.i(263337);
            EnumC1072a aVar = (EnumC1072a) Enum.valueOf(EnumC1072a.class, str);
            AppMethodBeat.o(263337);
            return aVar;
        }

        private EnumC1072a() {
            this.UEA = r3;
        }

        static {
            AppMethodBeat.i(263335);
            AppMethodBeat.o(263335);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalBakUIComponentFactory$UIComponentType$Companion;", "", "()V", "getType", "Lcom/tencent/mm/plugin/festival/ui/bak/FestivalBakUIComponentFactory$UIComponentType;", "intent", "Landroid/content/Intent;", "plugin-festival_release"})
        /* renamed from: com.tencent.mm.plugin.festival.ui.bak.a$a$a  reason: collision with other inner class name */
        public static final class C1073a {
            private C1073a() {
            }

            public /* synthetic */ C1073a(byte b2) {
                this();
            }
        }
    }

    public static Set<Class<? extends UIComponent>> bP(Intent intent) {
        EnumC1072a aVar;
        boolean z;
        AppMethodBeat.i(263338);
        p.h(intent, "intent");
        EnumC1072a.C1073a aVar2 = EnumC1072a.UEB;
        p.h(intent, "intent");
        int intExtra = intent.getIntExtra("FESTIVAL_INTENT_KEY_UICOMPONENT_TYPE", -1);
        EnumC1072a[] values = EnumC1072a.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                aVar = null;
                break;
            }
            aVar = values[i2];
            if (aVar.ordinal() == intExtra) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            Set<Class<? extends UIComponent>> of = ak.setOf(aVar.UEA);
            AppMethodBeat.o(263338);
            return of;
        }
        AppMethodBeat.o(263338);
        return null;
    }
}
