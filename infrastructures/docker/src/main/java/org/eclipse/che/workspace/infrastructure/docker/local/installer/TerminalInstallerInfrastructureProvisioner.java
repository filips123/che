/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.workspace.infrastructure.docker.local.installer;

import org.eclipse.che.commons.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Provides volumes configuration of machine for terminal installer
 *
 * <p>On Windows MUST be locate in "user.home" directory in case limitation windows+docker.
 *
 * @author Alexander Garagatyi
 */
@Singleton
public class TerminalInstallerInfrastructureProvisioner extends InstallerBinariesInfrastructureProvisioner {

    private static final String CONTAINER_TARGET = ":/mnt/che/terminal";
    private static final String TERMINAL         = "terminal";

    @Inject
    public TerminalInstallerInfrastructureProvisioner(
            @Nullable @Named("che.docker.volumes_agent_options") String agentVolumeOptions,
            @Named("che.workspace.terminal_linux_amd64") String terminalArchivePath) {
        super(agentVolumeOptions, terminalArchivePath, CONTAINER_TARGET, "org.eclipse.che.terminal", TERMINAL);
    }
}