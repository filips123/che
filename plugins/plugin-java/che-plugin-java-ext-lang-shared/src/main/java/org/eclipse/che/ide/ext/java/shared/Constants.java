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
package org.eclipse.che.ide.ext.java.shared;

/**
 * @author Artem Zatsarynnyi
 * @author Valeriy Svydenko
 */
public final class Constants {
  // project categories
  public static final String JAVA_CATEGORY = "Java";
  public static final String JAVA_ID = "java";
  // project attribute names
  public static final String LANGUAGE = "language";
  public static final String LANGUAGE_VERSION = "languageVersion";
  public static final String FRAMEWORK = "framework";
  public static final String CONTAINS_JAVA_FILES = "containsJavaFiles";
  public static final String SOURCE_FOLDER = "java.source.folder";
  public static final String OUTPUT_FOLDER = "java.output.folder";

  public static final String JAVAC = "javac";

  // LS requests timeout constants
  public static final int REQUEST_TIMEOUT = 10_000;
  public static final int EFFECTIVE_POM_REQUEST_TIMEOUT = 30_000;
  public static final int REIMPORT_MAVEN_PROJECTS_REQUEST_TIMEOUT = 60_000;

  // JSON RPC methods
  public static final String FILE_STRUCTURE = "java/filestructure";
  public static final String EXTERNAL_LIBRARIES = "java/externalLibraries";
  public static final String EXTERNAL_LIBRARIES_CHILDREN = "java/externalLibrariesChildren";
  public static final String EXTERNAL_LIBRARY_CHILDREN = "java/libraryChildren";
  public static final String EXTERNAL_LIBRARY_ENTRY = "java/libraryEntry";
  public static final String EXTERNAL_NODE_CONTENT = "java/libraryNodeContentByPath";
  public static final String CLASS_PATH_TREE = "java/classpathTree";
  public static final String ORGANIZE_IMPORTS = "java/organizeImports";
  public static final String EFFECTIVE_POM = "java/effective-pom";
  public static final String REIMPORT_MAVEN_PROJECTS = "java/reimport-maven-projects";
  public static final String IMPLEMENTERS = "java/implementers";
  public static final String USAGES = "java/usages";

  private Constants() {
    throw new UnsupportedOperationException("Unused constructor.");
  }
}
