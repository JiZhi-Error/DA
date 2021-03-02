package com.tencent.mm.ui.component;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelStore;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\b&\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014\u0018\u00010\u001cH&J \u0010\u001d\u001a\u00020\u00192\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fH\u0014J?\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\n2#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00170\"H\u0003J\"\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u00102\u001a\u00020\u0019H\u0014J\u0018\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\u00172\u0006\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206H\u0016J\u0012\u00108\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010,H\u0014J\b\u0010:\u001a\u00020\u0019H\u0014J-\u0010;\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u000e\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ\u0012\u0010B\u001a\u00020\u00192\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010C\u001a\u00020\u0019H\u0014J\u0012\u0010D\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010F\u001a\u00020\u0019H\u0014J\b\u0010G\u001a\u00020\u0019H\u0014J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0017H\u0016J$\u0010J\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010,2\u0006\u0010(\u001a\u00020)2\b\u0010K\u001a\u0004\u0018\u00010\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, hxF = {"Lcom/tencent/mm/ui/component/UIComponentActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroid/arch/lifecycle/ViewModelStore;", "savedInstanceState", "Landroid/os/Bundle;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "containUIC", "", "finish", "", "getViewModelStore", "importUIComponents", "", "initializeUIC", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "startActivityForResult", "options", "Companion", "libmmui_release"})
public abstract class UIComponentActivity extends AppCompatActivity {
    public static final a Companion = new a((byte) 0);
    private static final String TAG = "MicroMsg.UIComponentActivity";
    private HashMap _$_findViewCache;
    private UIComponent layoutUIC;
    private ViewModelStore modelStore;
    private Bundle savedInstanceState;
    private final HashSet<UIComponent> uiComponents = new HashSet<>();

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract Set<Class<? extends UIComponent>> importUIComponents();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    /* renamed from: onWindowFocusChanged  reason: collision with other method in class */
    public void m41onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Object, Boolean> {
        public static final b PRS = new b();

        static {
            AppMethodBeat.i(204837);
            AppMethodBeat.o(204837);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Object obj) {
            AppMethodBeat.i(204836);
            p.h(obj, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(204836);
            return bool;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "model", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Object, Boolean> {
        public static final c PRV = new c();

        static {
            AppMethodBeat.i(204840);
            AppMethodBeat.o(204840);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Object obj) {
            boolean z;
            AppMethodBeat.i(204839);
            p.h(obj, "model");
            if (!(obj instanceof SimpleUIComponent)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(204839);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/component/UIComponentActivity$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final <T extends ViewModel> T component(Class<T> cls) {
        p.h(cls, "modelClass");
        a aVar = a.PRN;
        T t = (T) a.b(this).get(cls);
        p.g(t, "UICProvider.of(this).get(modelClass)");
        return t;
    }

    public final UIComponent getLayoutUIC() {
        return this.layoutUIC;
    }

    public final void setLayoutUIC(UIComponent uIComponent) {
        this.layoutUIC = uIComponent;
    }

    @Override // android.arch.lifecycle.ViewModelStoreOwner, android.support.v4.app.FragmentActivity
    public ViewModelStore getViewModelStore() {
        ViewModelStore viewModelStore = this.modelStore;
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        mapStoreTo$default(this, super.getViewModelStore(), viewModelStore2, null, 4, null);
        this.modelStore = viewModelStore2;
        return viewModelStore2;
    }

    /* access modifiers changed from: protected */
    public void initializeUIC(HashSet<UIComponent> hashSet) {
        boolean z;
        p.h(hashSet, "uiComponents");
        Set<Class<? extends UIComponent>> importUIComponents = importUIComponents();
        if (importUIComponents != null) {
            Iterator<T> it = importUIComponents.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                a aVar = a.PRN;
                UIComponent uIComponent = (UIComponent) a.b(this).get(it.next());
                hashSet.add(uIComponent);
                if (uIComponent.getLayoutId() != 0) {
                    this.layoutUIC = uIComponent;
                    if (z2) {
                        throw new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic.");
                    }
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        this.savedInstanceState = bundle;
        initializeUIC(this.uiComponents);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onCreateBefore(bundle);
        }
        super.onCreate(bundle);
        getLifecycle().addObserver(new UIComponentActivity$onCreate$2(this, bundle));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        super.onStart();
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    /* renamed from: onWindowFocusChanged */
    public void m41onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onUserVisibleFocused();
            }
            return;
        }
        Iterator<T> it2 = this.uiComponents.iterator();
        while (it2.hasNext()) {
            it2.next().onUserVisibleUnFocused();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onNewIntent(intent);
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    it2.next().onNewIntent(intent);
                }
            }
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return;
            }
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onBackPressed()) {
                        return;
                    }
                }
                continue;
            }
        }
        finish();
    }

    @Override // android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        p.h(keyEvent, "event");
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            if (it.next().onKeyDown(i2, keyEvent)) {
                return true;
            }
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onKeyDown(i2, keyEvent)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        p.h(keyEvent, "event");
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            if (it.next().onKeyUp(i2, keyEvent)) {
                return true;
            }
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    if (it2.next().onKeyUp(i2, keyEvent)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        ViewModelStore viewModelStore = this.modelStore;
        ViewModelStore viewModelStore2 = super.getViewModelStore();
        p.g(viewModelStore2, "super.getViewModelStore()");
        mapStoreTo(viewModelStore, viewModelStore2, c.PRV);
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i2, i3, intent);
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    it2.next().onActivityResult(i2, i3, intent);
                }
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i2, strArr, iArr);
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    it2.next().onRequestPermissionsResult(i2, strArr, iArr);
                }
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onRestoreInstanceState(bundle);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (intent != null) {
            Iterator<T> it = this.uiComponents.iterator();
            while (it.hasNext()) {
                it.next().onStartActivityForResult(intent, i2, bundle);
            }
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        Intent intent = null;
        try {
            Field declaredField = Activity.class.getDeclaredField("mResultData");
            p.g(declaredField, LocaleUtil.ITALIAN);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (!(obj instanceof Intent)) {
                obj = null;
            }
            intent = (Intent) obj;
        } catch (Exception e2) {
        }
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            it.next().onBeforeFinish(intent);
        }
        g supportFragmentManager = getSupportFragmentManager();
        p.g(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        p.g(fragments, "supportFragmentManager.fragments");
        for (T t : fragments) {
            if (t instanceof UIComponentFragment) {
                Iterator<T> it2 = t.uiComponents.iterator();
                while (it2.hasNext()) {
                    it2.next().onBeforeFinish(intent);
                }
            }
        }
        super.finish();
        Iterator<T> it3 = this.uiComponents.iterator();
        while (it3.hasNext()) {
            it3.next().onFinished();
        }
        g supportFragmentManager2 = getSupportFragmentManager();
        p.g(supportFragmentManager2, "supportFragmentManager");
        List<Fragment> fragments2 = supportFragmentManager2.getFragments();
        p.g(fragments2, "supportFragmentManager.fragments");
        for (T t2 : fragments2) {
            if (t2 instanceof UIComponentFragment) {
                Iterator<T> it4 = t2.uiComponents.iterator();
                while (it4.hasNext()) {
                    it4.next().onFinished();
                }
            }
        }
    }

    static /* synthetic */ void mapStoreTo$default(UIComponentActivity uIComponentActivity, ViewModelStore viewModelStore, ViewModelStore viewModelStore2, kotlin.g.a.b bVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mapStoreTo");
        }
        uIComponentActivity.mapStoreTo(viewModelStore, viewModelStore2, (i2 & 4) != 0 ? b.PRS : bVar);
    }

    private final void mapStoreTo(ViewModelStore viewModelStore, ViewModelStore viewModelStore2, kotlin.g.a.b<Object, Boolean> bVar) {
        if (viewModelStore != null) {
            Field declaredField = ViewModelStore.class.getDeclaredField("mMap");
            p.g(declaredField, "ViewModelStore::class.ja….getDeclaredField(\"mMap\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewModelStore);
            if (obj == null) {
                throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
            }
            HashMap hashMap = (HashMap) obj;
            Object obj2 = declaredField.get(viewModelStore2);
            if (obj2 == null) {
                throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
            }
            HashMap hashMap2 = (HashMap) obj2;
            for (Map.Entry entry : hashMap.entrySet()) {
                if (bVar.invoke(entry.getValue()).booleanValue()) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public final boolean containUIC(Class<? extends UIComponent> cls) {
        p.h(cls, "modelClass");
        Iterator<T> it = this.uiComponents.iterator();
        while (it.hasNext()) {
            if (p.j(it.next().getClass(), cls)) {
                return true;
            }
        }
        return false;
    }
}
