package com.tencent.mm.plugin.gamelife.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0011H\u0014J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingFragmentFinish;", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActivityController;", "()V", "chattingCompat", "Lcom/tencent/mm/chatting/IChattingCompat;", "getChattingCompat", "()Lcom/tencent/mm/chatting/IChattingCompat;", "setChattingCompat", "(Lcom/tencent/mm/chatting/IChattingCompat;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onChattingFinishBegin", "", "onChattingFinishEnd", "onChattingUIEnter", "onChattingUIExit", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-gamelife_release"})
public abstract class GameLifeChattingCompatUI extends MMActivity implements a.b, a.c, a.d {
    public static final a ycA = new a((byte) 0);
    private HashMap _$_findViewCache;
    com.tencent.mm.j.a vQb;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
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

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        a.C0358a.AbstractC0359a aVar = a.C0358a.gCq;
        this.vQb = aVar != null ? aVar.a(this) : null;
        com.tencent.mm.j.a aVar2 = this.vQb;
        if (aVar2 != null) {
            aVar2.a((a.b) this);
        }
        com.tencent.mm.j.a aVar3 = this.vQb;
        if (aVar3 != null) {
            aVar3.a((a.c) this);
        }
        com.tencent.mm.j.a aVar4 = this.vQb;
        if (aVar4 != null) {
            aVar4.anu();
        }
        super.onCreate(bundle);
        com.tencent.mm.j.a aVar5 = this.vQb;
        if (aVar5 != null) {
            aVar5.anv();
        }
        getWindow().setSoftInputMode(50);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            aVar.b(this);
        }
        com.tencent.mm.j.a aVar2 = this.vQb;
        if (aVar2 != null) {
            aVar2.onDestroy();
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar == null || !aVar.dispatchKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // com.tencent.mm.j.a.b
    public final void anx() {
        Log.i("GameLife.ChattingCompatUI", "[onChattingUIEnter] ...");
    }

    @Override // com.tencent.mm.j.a.b
    public final boolean any() {
        Log.i("GameLife.ChattingCompatUI", "[onChattingUIExit] ...");
        return true;
    }

    @Override // com.tencent.mm.j.a.d
    public final void anz() {
        Log.i("GameLife.ChattingCompatUI", "[onChattingFinishBegin] ...");
    }

    @Override // com.tencent.mm.j.a.d
    public final void anA() {
        Log.i("GameLife.ChattingCompatUI", "[onChattingFinishEnd] ...");
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            aVar.ant();
        }
    }
}
