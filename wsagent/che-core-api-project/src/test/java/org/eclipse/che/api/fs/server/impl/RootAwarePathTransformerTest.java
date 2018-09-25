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
package org.eclipse.che.api.fs.server.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.che.api.fs.server.WsPathUtils;
import org.eclipse.che.api.project.server.impl.RootDirPathProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Tests for {@link RootAwarePathTransformer} */
public class RootAwarePathTransformerTest {

  private RootAwarePathTransformer rootAwarePathTransformer;

  @BeforeMethod
  public void setUp() throws Exception {
    rootAwarePathTransformer =
        new RootAwarePathTransformer(new DummyProvider(Paths.get("/").toFile()));
  }

  @Test
  public void shouldReturnFsRootWhenWsRootIsTransformed() throws Exception {
    Path expected = Paths.get("/");

    Path actual = rootAwarePathTransformer.transform(WsPathUtils.ROOT);

    assertEquals(actual, expected);
  }

  @Test
  public void shouldReturnWsRootWhenFsRootIsTransformed() throws Exception {
    String expected = WsPathUtils.ROOT;

    String actual = rootAwarePathTransformer.transform(Paths.get("/"));

    assertEquals(actual, expected);
  }

  @Test
  public void shouldTransformAbsoluteWsPath() throws Exception {
    Path expected = Paths.get("/a/b/c");

    Path actual = rootAwarePathTransformer.transform("/a/b/c");

    assertEquals(actual, expected);
  }

  @Test
  public void shouldTransformRelativeWsPath() throws Exception {
    Path expected = Paths.get("/a/b/c");

    Path actual = rootAwarePathTransformer.transform("a/b/c");

    assertEquals(actual, expected);
  }

  @Test
  public void shouldTransformWsPathToAbsoluteFsPath() throws Exception {
    String wsPath = "a/b/c";

    Path fsPath = rootAwarePathTransformer.transform(wsPath);

    assertFalse(wsPath.startsWith(WsPathUtils.ROOT));
    assertTrue(fsPath.isAbsolute());
  }

  @Test
  public void shouldTransformFsPathToAbsoluteWsPath() throws Exception {
    Path fsPath = Paths.get("a/b/c");

    String wsPath = rootAwarePathTransformer.transform(fsPath);

    assertFalse(fsPath.isAbsolute());
    assertTrue(wsPath.startsWith(WsPathUtils.ROOT));
  }

  private static class DummyProvider extends RootDirPathProvider {

    public DummyProvider(File file) {
      this.rootFile = file;
    }
  }
}
