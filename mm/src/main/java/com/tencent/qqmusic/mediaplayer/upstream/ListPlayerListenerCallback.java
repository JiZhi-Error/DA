package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListPlayerListenerCallback implements PlayerListenerCallback {
    private final CopyOnWriteArrayList<PlayerListenerCallback> mCallbacks = new CopyOnWriteArrayList<>();

    public ListPlayerListenerCallback() {
        AppMethodBeat.i(76526);
        AppMethodBeat.o(76526);
    }

    public synchronized void add(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(76527);
        this.mCallbacks.add(playerListenerCallback);
        AppMethodBeat.o(76527);
    }

    public synchronized void add(ListPlayerListenerCallback listPlayerListenerCallback) {
        AppMethodBeat.i(76528);
        this.mCallbacks.addAll(listPlayerListenerCallback.toCollection());
        AppMethodBeat.o(76528);
    }

    public synchronized void addAll(List<PlayerListenerCallback> list) {
        AppMethodBeat.i(76529);
        this.mCallbacks.addAll(list);
        AppMethodBeat.o(76529);
    }

    public synchronized List<PlayerListenerCallback> toCollection() {
        ArrayList arrayList;
        AppMethodBeat.i(76530);
        arrayList = new ArrayList();
        arrayList.addAll(this.mCallbacks);
        AppMethodBeat.o(76530);
        return arrayList;
    }

    public synchronized void remove(PlayerListenerCallback playerListenerCallback) {
        AppMethodBeat.i(76531);
        this.mCallbacks.remove(playerListenerCallback);
        AppMethodBeat.o(76531);
    }

    public synchronized void clear() {
        AppMethodBeat.i(76532);
        this.mCallbacks.clear();
        AppMethodBeat.o(76532);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i2) {
        AppMethodBeat.i(76533);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onBufferingUpdate(baseMediaPlayer, i2);
        }
        AppMethodBeat.o(76533);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(76534);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onCompletion(baseMediaPlayer);
        }
        AppMethodBeat.o(76534);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i2) {
        AppMethodBeat.i(76535);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onSeekComplete(baseMediaPlayer, i2);
        }
        AppMethodBeat.o(76535);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onError(BaseMediaPlayer baseMediaPlayer, int i2, int i3, int i4) {
        AppMethodBeat.i(76536);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onError(baseMediaPlayer, i2, i3, i4);
        }
        AppMethodBeat.o(76536);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(76537);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onPrepared(baseMediaPlayer);
        }
        AppMethodBeat.o(76537);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(76538);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onStarted(baseMediaPlayer);
        }
        AppMethodBeat.o(76538);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i2) {
        AppMethodBeat.i(76539);
        Iterator<PlayerListenerCallback> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(baseMediaPlayer, i2);
        }
        AppMethodBeat.o(76539);
    }
}
