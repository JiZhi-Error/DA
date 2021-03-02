package com.tencent.mm.plugin.multitask.ui.panel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010+\u001a\u0004\u0018\u00010\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bJ\u0018\u0010/\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u0001002\u0006\u00101\u001a\u00020-J\n\u00102\u001a\u0004\u0018\u00010\fH\u0016J\b\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u0004\u0018\u00010\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bJ\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\f2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u0004\u0018\u00010\u00142\u0006\u0010;\u001a\u00020-J\u000e\u0010<\u001a\u00020=2\u0006\u00108\u001a\u000209J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001aH\u0016J\b\u0010A\u001a\u00020=H\u0016J\b\u0010B\u001a\u00020=H\u0016J\u0018\u0010C\u001a\u0004\u0018\u00010\f2\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f00J\"\u0010C\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010\b2\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f00J\"\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020=H\u0016J\u0012\u0010K\u001a\u00020?2\b\u0010L\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010M\u001a\u00020?2\u0006\u0010N\u001a\u00020OH\u0016J\u0012\u0010P\u001a\u00020?2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010R\u001a\u00020?2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010S\u001a\u00020?2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010T\u001a\u00020?H\u0016J\u0018\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020XH\u0016J\u0018\u0010Y\u001a\u00020=2\u0006\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020XH\u0016J\u0012\u0010Z\u001a\u00020?2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020?H\u0016J\b\u0010^\u001a\u00020?H\u0016J\b\u0010_\u001a\u00020?H\u0016J\b\u0010`\u001a\u00020?H\u0016J-\u0010a\u001a\u00020?2\u0006\u0010F\u001a\u00020-2\u000e\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0c2\u0006\u0010d\u001a\u00020eH\u0016¢\u0006\u0002\u0010fJ\u0012\u0010g\u001a\u00020?2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010h\u001a\u00020?H\u0016J\u0012\u0010i\u001a\u00020?2\b\u0010j\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010k\u001a\u00020?H\u0016J$\u0010l\u001a\u00020?2\b\u0010m\u001a\u0004\u0018\u00010I2\u0006\u0010F\u001a\u00020-2\b\u0010n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010o\u001a\u00020?H\u0016J\b\u0010p\u001a\u00020?H\u0016J\b\u0010q\u001a\u00020?H\u0016J\u000e\u0010r\u001a\u00020=2\u0006\u0010.\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR6\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0 j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f`!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\f0'j\b\u0012\u0004\u0012\u00020\f`(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006s"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroid/support/v7/app/AppCompatActivity;Landroid/os/Bundle;)V", "TAG", "", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "currentUiComponent", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "getCurrentUiComponent", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "setCurrentUiComponent", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;)V", "getOnCreateInstanceState", "()Landroid/os/Bundle;", "panelView", "Landroid/view/View;", "getPanelView", "()Landroid/view/View;", "setPanelView", "(Landroid/view/View;)V", "panelWindowContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "getPanelWindowContainer", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "setPanelWindowContainer", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;)V", "uiComponentMaps", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUiComponentMaps", "()Ljava/util/HashMap;", "setUiComponentMaps", "(Ljava/util/HashMap;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "findUIComponent", "componetType", "", "id", "findUIComponentClass", "Ljava/lang/Class;", "multiTaskType", "getCurrentUIC", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getSnapShotUIC", "getTitle", "getUIComponent", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getView", "position", "hideUIComponent", "", "initPanelWindowContainer", "", "container", "isMinusScreenUIC", "isSingleSceneShow", "newUIComponent", "modelClass", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "removeUIComponet", "ui-multitask_release"})
public class a implements com.tencent.mm.plugin.multitask.ui.a {
    public MultiTaskPanelContainer AeE;
    public View AeF;
    public MultiTaskUIComponent AeG;
    HashMap<String, MultiTaskUIComponent> AeH = new HashMap<>();
    private final Bundle AeI;
    public final String TAG = "MicroMsg.MultiTask.MultiTaskPanelItem";
    public final AppCompatActivity tUQ;
    final HashSet<MultiTaskUIComponent> uiComponents = new HashSet<>();

    public a(AppCompatActivity appCompatActivity, Bundle bundle) {
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236565);
        this.tUQ = appCompatActivity;
        this.AeI = bundle;
        AppMethodBeat.o(236565);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        AppMethodBeat.i(236566);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        AppMethodBeat.o(236566);
    }

    private MultiTaskUIComponent i(String str, Class<? extends MultiTaskUIComponent> cls) {
        AppMethodBeat.i(236553);
        p.h(cls, "modelClass");
        MultiTaskUIComponent multiTaskUIComponent = null;
        if (SimpleUIComponent.class.isAssignableFrom(cls)) {
            try {
                multiTaskUIComponent = (MultiTaskUIComponent) cls.getConstructor(AppCompatActivity.class).newInstance(this.tUQ);
            } catch (NoSuchMethodException e2) {
                RuntimeException runtimeException = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e2);
                AppMethodBeat.o(236553);
                throw runtimeException;
            } catch (IllegalAccessException e3) {
                RuntimeException runtimeException2 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e3);
                AppMethodBeat.o(236553);
                throw runtimeException2;
            } catch (InstantiationException e4) {
                RuntimeException runtimeException3 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e4);
                AppMethodBeat.o(236553);
                throw runtimeException3;
            } catch (InvocationTargetException e5) {
                RuntimeException runtimeException4 = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)), e5);
                AppMethodBeat.o(236553);
                throw runtimeException4;
            }
        }
        if (multiTaskUIComponent != null) {
            this.uiComponents.add(multiTaskUIComponent);
            if (str != null) {
                this.AeH.put(str, multiTaskUIComponent);
            }
        }
        AppMethodBeat.o(236553);
        return multiTaskUIComponent;
    }

    public final MultiTaskUIComponent bK(int i2, String str) {
        AppMethodBeat.i(236554);
        p.h(str, "id");
        for (T t : this.uiComponents) {
            if (t.Js(i2) && this.AeH.containsKey(str) && p.j(t, this.AeH.get(str))) {
                AppMethodBeat.o(236554);
                return t;
            }
        }
        AppMethodBeat.o(236554);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if (r2 == com.tencent.mm.plugin.multitask.ui.a.b.MODE_SHOW_SNAPSHOT_SCENE) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aGO(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.ui.panel.a.aGO(java.lang.String):boolean");
    }

    public final MultiTaskUIComponent i(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(236556);
        p.h(multiTaskInfo, "multiTaskInfo");
        int i2 = multiTaskInfo.field_type;
        this.AeG = null;
        for (T t : this.uiComponents) {
            if (t.Js(i2) && this.AeH.containsKey(multiTaskInfo.field_id) && p.j(t, this.AeH.get(multiTaskInfo.field_id))) {
                if (t.dks() == a.b.MODE_SHOW_SINGLE_SCENE) {
                    t.getRootView().setVisibility(0);
                }
                this.AeG = t;
                erG();
                AppMethodBeat.o(236556);
                return t;
            }
        }
        PluginMultiTask.a aVar = PluginMultiTask.zZu;
        Class<? extends MultiTaskUIComponent> cls = (Class) PluginMultiTask.zZs.get(Integer.valueOf(i2));
        if (cls != null) {
            String str = multiTaskInfo.field_id;
            p.g(cls, "componentClass");
            MultiTaskUIComponent i3 = i(str, cls);
            if (i3 != null) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                i3.zZC = ((MultiTaskUIC) com.tencent.mm.ui.component.a.b(this.tUQ).get(MultiTaskUIC.class)).AfB;
            } else {
                i3 = null;
            }
            if ((i3 != null ? i3.dks() : null) == a.b.MODE_SHOW_SINGLE_SCENE) {
                MultiTaskPanelContainer multiTaskPanelContainer = this.AeE;
                if (multiTaskPanelContainer != null) {
                    View inflate = this.tUQ.getLayoutInflater().inflate(i3.getLayoutId(), (ViewGroup) null);
                    multiTaskPanelContainer.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
                    if (inflate != null) {
                        i3.setRootView(inflate);
                    }
                    i3.onCreateBefore(this.AeI);
                    i3.dk(multiTaskInfo);
                    i3.onCreate(this.AeI);
                    i3.onCreateAfter(this.AeI);
                    i3.onStart();
                    if ((this.tUQ instanceof MMFragmentActivity) && !((MMFragmentActivity) this.tUQ).isPaused()) {
                        i3.onResume();
                    }
                }
            } else {
                MultiTaskPanelContainer multiTaskPanelContainer2 = this.AeE;
                if (!(multiTaskPanelContainer2 == null || i3 == null)) {
                    i3.setRootView(multiTaskPanelContainer2);
                }
            }
            this.AeG = i3;
            AppMethodBeat.o(236556);
            return i3;
        }
        AppMethodBeat.o(236556);
        return null;
    }

    public final MultiTaskUIComponent aGP(String str) {
        MultiTaskPanelContainer multiTaskPanelContainer;
        AppMethodBeat.i(236557);
        p.h(str, "id");
        for (T t : this.uiComponents) {
            if (t.Js(1048576) && this.AeH.containsKey(str) && p.j(t, this.AeH.get(str))) {
                AppMethodBeat.o(236557);
                return t;
            }
        }
        PluginMultiTask.a aVar = PluginMultiTask.zZu;
        Class<? extends MultiTaskUIComponent> cls = (Class) PluginMultiTask.zZs.get(1048576);
        if (cls != null) {
            p.g(cls, "componentClass");
            MultiTaskUIComponent i2 = i(str, cls);
            if ((i2 != null ? i2.dks() : null) == a.b.MODE_SHOW_SNAPSHOT_SCENE && (multiTaskPanelContainer = this.AeE) != null) {
                View inflate = this.tUQ.getLayoutInflater().inflate(i2.getLayoutId(), (ViewGroup) null);
                multiTaskPanelContainer.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
                if (inflate != null) {
                    i2.setRootView(inflate);
                    i2.getRootView().setVisibility(8);
                }
                i2.dk(null);
                AppMethodBeat.o(236557);
                return i2;
            }
        }
        AppMethodBeat.o(236557);
        return null;
    }

    public void a(MultiTaskPanelContainer multiTaskPanelContainer) {
        AppMethodBeat.i(236558);
        p.h(multiTaskPanelContainer, "container");
        onCreate(this.AeI);
        onStart();
        onResume();
        AppMethodBeat.o(236558);
    }

    public void onCreate(Bundle bundle) {
    }

    public final void onStart() {
        AppMethodBeat.i(236559);
        Log.i(this.TAG, "onStart");
        AppMethodBeat.o(236559);
    }

    public final void onResume() {
        AppMethodBeat.i(236560);
        Log.i(this.TAG, "onResume");
        AppMethodBeat.o(236560);
    }

    public void onDestroy() {
        AppMethodBeat.i(236561);
        Log.i(this.TAG, "onDestroy");
        AppMethodBeat.o(236561);
    }

    public static boolean e(KeyEvent keyEvent) {
        AppMethodBeat.i(236562);
        p.h(keyEvent, "event");
        AppMethodBeat.o(236562);
        return false;
    }

    public final void erG() {
        AppMethodBeat.i(236563);
        String str = this.TAG;
        Object[] objArr = new Object[1];
        MultiTaskUIComponent multiTaskUIComponent = this.AeG;
        objArr[0] = multiTaskUIComponent != null ? multiTaskUIComponent.toString() : null;
        Log.i(str, "onMultiTaskPageResume, uic: %s", objArr);
        AppMethodBeat.o(236563);
    }

    public final void dkr() {
        AppMethodBeat.i(236564);
        String str = this.TAG;
        Object[] objArr = new Object[1];
        MultiTaskUIComponent multiTaskUIComponent = this.AeG;
        objArr[0] = multiTaskUIComponent != null ? multiTaskUIComponent.toString() : null;
        Log.i(str, "onMultiTaskPagePause, uic: %s", objArr);
        MultiTaskUIComponent multiTaskUIComponent2 = this.AeG;
        if (multiTaskUIComponent2 != null) {
            multiTaskUIComponent2.dkr();
            AppMethodBeat.o(236564);
            return;
        }
        AppMethodBeat.o(236564);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public a.b dks() {
        return a.b.MODE_NONE;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.panel.a$a  reason: collision with other inner class name */
    static final class C1529a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f AeJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1529a(z.f fVar) {
            super(0);
            this.AeJ = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View rootView;
            AppMethodBeat.i(236552);
            T t = this.AeJ.SYG;
            if (!(t == null || (rootView = t.getRootView()) == null)) {
                rootView.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(236552);
            return xVar;
        }
    }
}
