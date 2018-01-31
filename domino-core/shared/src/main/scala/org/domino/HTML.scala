package org.domino

/**
 * The HTML object aggregates the factories for elements and attributes. It also
 * provides implicit conversions from objects into nodes.
 *
 * Import the members of this object in functions that are intended to return an
 * HTML tree. Do not import it as a top-level import as that may lead to namespace
 * collisions.
 */
object HTML extends Elements with Attributes with NodeImplicits
