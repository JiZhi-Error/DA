package com.tencent.tavkit.composition.builder;

import java.util.HashMap;
import java.util.List;

class AudioParamsInfo {
    List<AudioInfo> audioInfos;
    HashMap<String, AudioTransitionInfo> transitionMap;

    AudioParamsInfo(List<AudioInfo> list, HashMap<String, AudioTransitionInfo> hashMap) {
        this.audioInfos = list;
        this.transitionMap = hashMap;
    }
}
