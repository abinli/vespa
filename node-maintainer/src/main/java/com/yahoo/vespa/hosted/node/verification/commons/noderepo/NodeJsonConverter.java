// Copyright 2017 Yahoo Holdings. Licensed under the terms of the Apache 2.0 license. See LICENSE in the project root.
package com.yahoo.vespa.hosted.node.verification.commons.noderepo;

import com.yahoo.vespa.hosted.node.verification.spec.retrievers.HardwareInfo;

/**
 * Converts a NodeRepoJsonModel object to a HardwareInfo object.
 * 
 * @author olaaun
 * @author sgrostad
 */
public class NodeJsonConverter {

    private static void addStandardSpecifications(HardwareInfo nodeRepoHardwareInfo) {
        nodeRepoHardwareInfo.setInterfaceSpeedMbs(1000);
    }

    protected static void setIpv6Interface(NodeRepoJsonModel nodeRepoJsonModel, HardwareInfo nodeRepoHardwareInfo) {
        if (nodeRepoJsonModel.getIpv6Address() != null) {
            nodeRepoHardwareInfo.setIpv6Interface(true);
        }
    }

    protected static void setIpv4Interface(NodeRepoJsonModel nodeRepoJsonModel, HardwareInfo nodeRepoHardwareInfo) {
        if (nodeRepoJsonModel.getIpv4Address() != null) {
            nodeRepoHardwareInfo.setIpv4Interface(true);
        }
    }

    public static HardwareInfo convertJsonModelToHardwareInfo(NodeRepoJsonModel nodeRepoJsonModel) {
        HardwareInfo nodeRepoHardwareInfo = nodeRepoJsonModel.copyToHardwareInfo();
        addStandardSpecifications(nodeRepoHardwareInfo);
        setIpv4Interface(nodeRepoJsonModel, nodeRepoHardwareInfo);
        setIpv6Interface(nodeRepoJsonModel, nodeRepoHardwareInfo);
        return nodeRepoHardwareInfo;
    }

}
