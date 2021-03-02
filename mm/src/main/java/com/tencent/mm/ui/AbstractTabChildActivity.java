package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class AbstractTabChildActivity extends AppCompatActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static abstract class AbStractTabFragment extends MMFragment implements n {
        protected boolean OwA;
        protected boolean OwB = false;
        private boolean Owu;
        private boolean Owv;
        private boolean Oww;
        protected boolean Owx;
        protected boolean Owy = false;
        protected boolean Owz = false;
        private Bundle savedInstanceState;

        public abstract void gGA();

        @Override // com.tencent.mm.ui.n
        public abstract void gGB();

        @Override // com.tencent.mm.ui.n
        public abstract void gGC();

        /* access modifiers changed from: protected */
        public abstract void gGu();

        /* access modifiers changed from: protected */
        public abstract void gGv();

        /* access modifiers changed from: protected */
        public abstract void gGw();

        /* access modifiers changed from: protected */
        public abstract void gGx();

        /* access modifiers changed from: protected */
        public abstract void gGy();

        /* access modifiers changed from: protected */
        public abstract void gGz();

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.Owv = true;
            this.savedInstanceState = bundle;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return 0;
        }

        @Override // com.tencent.mm.ui.n
        public final void gGD() {
            gGB();
            this.Oww = true;
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.MMFragment
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 0) {
                return false;
            }
            return super.onKeyDown(i2, keyEvent);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            Log.i("MicroMsg.INIT", "onResume");
            super.onResume();
            Log.i("MicroMsg.INIT", "resumeWithVerify %s", Boolean.valueOf(this.Owy));
            LauncherUI instance = LauncherUI.getInstance();
            if (instance != null && instance.ODU) {
                this.Owy = true;
                if (this.Owz) {
                    gGH();
                    this.Owz = false;
                }
            }
        }

        @Override // com.tencent.mm.ui.n
        public final void gGE() {
        }

        @Override // com.tencent.mm.ui.n
        public final void gGF() {
            this.Owz = true;
        }

        private void gGG() {
            Log.i("MicroMsg.INIT", "checkNeedRecreate");
            if (this.Owv) {
                gGu();
                this.Owv = false;
            } else if (this.Owu) {
                if (this.OwB) {
                    gGz();
                }
                gGu();
                Log.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                this.Owu = false;
            }
            this.OwB = true;
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            super.onPause();
            Log.i("MicroMsg.INIT", "onPause");
            this.OwA = true;
            if (!this.OwA) {
                return;
            }
            if (!this.Owx) {
                this.OwA = false;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            gGx();
            Log.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.Owx = false;
            this.OwA = false;
        }

        @Override // com.tencent.mm.ui.n
        public final void gGH() {
            Log.i("MicroMsg.INIT", "deliverOnTabResume %s", Boolean.valueOf(this.Owy));
            if (this.Owy) {
                gGG();
                long currentTimeMillis = System.currentTimeMillis();
                if (this.Oww) {
                    this.Oww = false;
                    gGC();
                }
                gGv();
                Log.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.Owx = true;
                this.Owy = false;
            }
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onStop() {
            super.onStop();
            gGy();
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onStart() {
            super.onStart();
            LauncherUI instance = LauncherUI.getInstance();
            if (instance != null && instance.ODU) {
                gGw();
            }
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            if (this.OwB) {
                gGz();
            }
            super.onDestroy();
        }

        @Override // com.tencent.mm.ui.MMFragment
        public boolean supportNavigationSwipeBack() {
            return false;
        }
    }
}
