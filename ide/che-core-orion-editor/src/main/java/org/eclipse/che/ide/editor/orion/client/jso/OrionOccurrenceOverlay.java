/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.editor.orion.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The 'Occurrence Object' for Orion occurrences See <a
 * href="https://wiki.eclipse.org/Orion/Documentation/Developer_Guide/Plugging_into_the_editor#orion.edit.occurrences">Orion
 * Occurrences</a>
 *
 * @author Xavier Coulon, Red Hat
 */
public class OrionOccurrenceOverlay extends JavaScriptObject {
  protected OrionOccurrenceOverlay() {}

  public static native OrionOccurrenceOverlay create() /*-{
	    return {};
	}-*/;

  /** @param offset The offset into the file for the start of the occurrence. */
  public final native void setStart(int offset) /*-{
        this.start = offset;
    }-*/;

  /** @param offset The offset into the file for the end of the occurrence. */
  public final native void setEnd(int offset) /*-{
        this.end = offset;
    }-*/;
}
