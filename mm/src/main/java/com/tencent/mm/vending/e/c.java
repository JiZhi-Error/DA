package com.tencent.mm.vending.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> QZO = new ArrayList();
    private boolean QZP = true;

    public c() {
        AppMethodBeat.i(74908);
        AppMethodBeat.o(74908);
    }

    @Override // com.tencent.mm.vending.e.b
    public final synchronized void keep(_Target _target) {
        AppMethodBeat.i(74909);
        if (!this.QZP) {
            Assert.assertNotNull(_target);
            _target.dead();
            AppMethodBeat.o(74909);
        } else {
            this.QZO.add(new WeakReference<>(_target));
            AppMethodBeat.o(74909);
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public final synchronized void dead() {
        AppMethodBeat.i(74910);
        if (!this.QZP) {
            AppMethodBeat.o(74910);
        } else {
            for (WeakReference<_Target> weakReference : this.QZO) {
                _Target _target = weakReference.get();
                if (_target != null) {
                    _target.dead();
                }
            }
            this.QZO.clear();
            this.QZP = false;
            AppMethodBeat.o(74910);
        }
    }
}
