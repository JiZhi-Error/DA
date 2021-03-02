package com.tencent.thumbplayer.core.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.player.TPNativePlayer;

public class TPNativePlayerConnectionMgr {
    private boolean mInited = false;
    private boolean mIsLibLoaded = false;
    private long mNativeContext = 0;

    private native int _activeAllConnections();

    private native int _activeConnection(int i2);

    private native int _addConnection(Object obj, Object obj2, Object obj3, Object obj4);

    private native int _addConnectionWithAddr(long j2, Object obj, long j3, Object obj2);

    private native void _deactiveAllConnections();

    private native void _deactiveConnection(int i2);

    private native void _init();

    private native void _removeConnection(int i2);

    private native void _unInit();

    public TPNativePlayerConnectionMgr() {
        AppMethodBeat.i(189868);
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            this.mIsLibLoaded = true;
            AppMethodBeat.o(189868);
        } catch (UnsupportedOperationException e2) {
            this.mIsLibLoaded = false;
            AppMethodBeat.o(189868);
        }
    }

    public void init() {
        AppMethodBeat.i(189869);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189869);
            throw unsupportedOperationException;
        } else if (this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to init due to invalid state.");
            AppMethodBeat.o(189869);
            throw illegalStateException;
        } else {
            this.mInited = true;
            _init();
            AppMethodBeat.o(189869);
        }
    }

    public void unInit() {
        AppMethodBeat.i(189870);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189870);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            AppMethodBeat.o(189870);
        } else {
            this.mInited = false;
            _unInit();
            AppMethodBeat.o(189870);
        }
    }

    public int addConnection(TPNativePlayer tPNativePlayer, TPNativePlayerConnectionNode tPNativePlayerConnectionNode, TPNativePlayer tPNativePlayer2, TPNativePlayerConnectionNode tPNativePlayerConnectionNode2) {
        AppMethodBeat.i(189871);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189871);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189871);
            throw illegalStateException;
        } else {
            int _addConnection = _addConnection(tPNativePlayer, tPNativePlayerConnectionNode, tPNativePlayer2, tPNativePlayerConnectionNode2);
            AppMethodBeat.o(189871);
            return _addConnection;
        }
    }

    public int addConnection(long j2, TPNativePlayerConnectionNode tPNativePlayerConnectionNode, long j3, TPNativePlayerConnectionNode tPNativePlayerConnectionNode2) {
        AppMethodBeat.i(189872);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189872);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189872);
            throw illegalStateException;
        } else {
            int _addConnectionWithAddr = _addConnectionWithAddr(j2, tPNativePlayerConnectionNode, j3, tPNativePlayerConnectionNode2);
            AppMethodBeat.o(189872);
            return _addConnectionWithAddr;
        }
    }

    public void removeConnection(int i2) {
        AppMethodBeat.i(189873);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189873);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189873);
            throw illegalStateException;
        } else {
            _removeConnection(i2);
            AppMethodBeat.o(189873);
        }
    }

    public int activeConnection(int i2) {
        AppMethodBeat.i(189874);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189874);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189874);
            throw illegalStateException;
        } else {
            int _activeConnection = _activeConnection(i2);
            AppMethodBeat.o(189874);
            return _activeConnection;
        }
    }

    public int activeAllConnections() {
        AppMethodBeat.i(189875);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189875);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189875);
            throw illegalStateException;
        } else {
            int _activeAllConnections = _activeAllConnections();
            AppMethodBeat.o(189875);
            return _activeAllConnections;
        }
    }

    public void deactiveConnection(int i2) {
        AppMethodBeat.i(189876);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189876);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189876);
            throw illegalStateException;
        } else {
            _deactiveConnection(i2);
            AppMethodBeat.o(189876);
        }
    }

    public void deactiveAllConnections() {
        AppMethodBeat.i(189877);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189877);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to addConnection due to invalid state.");
            AppMethodBeat.o(189877);
            throw illegalStateException;
        } else {
            _deactiveAllConnections();
            AppMethodBeat.o(189877);
        }
    }
}
