package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google</b>
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAutoLibraryAccessors laccForComGoogleAutoLibraryAccessors = new ComGoogleAutoLibraryAccessors(owner);
        private final ComGoogleGuavaLibraryAccessors laccForComGoogleGuavaLibraryAccessors = new ComGoogleGuavaLibraryAccessors(owner);
        private final ComGoogleTestingLibraryAccessors laccForComGoogleTestingLibraryAccessors = new ComGoogleTestingLibraryAccessors(owner);
        private final ComGoogleTruthLibraryAccessors laccForComGoogleTruthLibraryAccessors = new ComGoogleTruthLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.auto</b>
         */
        public ComGoogleAutoLibraryAccessors getAuto() {
            return laccForComGoogleAutoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.guava</b>
         */
        public ComGoogleGuavaLibraryAccessors getGuava() {
            return laccForComGoogleGuavaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.testing</b>
         */
        public ComGoogleTestingLibraryAccessors getTesting() {
            return laccForComGoogleTestingLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.truth</b>
         */
        public ComGoogleTruthLibraryAccessors getTruth() {
            return laccForComGoogleTruthLibraryAccessors;
        }

    }

    public static class ComGoogleAutoLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAutoAutoLibraryAccessors laccForComGoogleAutoAutoLibraryAccessors = new ComGoogleAutoAutoLibraryAccessors(owner);

        public ComGoogleAutoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.auto.auto</b>
         */
        public ComGoogleAutoAutoLibraryAccessors getAuto() {
            return laccForComGoogleAutoAutoLibraryAccessors;
        }

    }

    public static class ComGoogleAutoAutoLibraryAccessors extends SubDependencyFactory {

        public ComGoogleAutoAutoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>com.google.auto:auto-common</b> coordinates and
         * with version reference <b>com.google.auto.auto.common</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommon() {
            return create("com.google.auto.auto.common");
        }

    }

    public static class ComGoogleGuavaLibraryAccessors extends SubDependencyFactory {

        public ComGoogleGuavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>guava</b> with <b>com.google.guava:guava</b> coordinates and
         * with version reference <b>com.google.guava.guava</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() {
            return create("com.google.guava.guava");
        }

    }

    public static class ComGoogleTestingLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileLibraryAccessors laccForComGoogleTestingCompileLibraryAccessors = new ComGoogleTestingCompileLibraryAccessors(owner);

        public ComGoogleTestingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile</b>
         */
        public ComGoogleTestingCompileLibraryAccessors getCompile() {
            return laccForComGoogleTestingCompileLibraryAccessors;
        }

    }

    public static class ComGoogleTestingCompileLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleTestingCompileCompileLibraryAccessors laccForComGoogleTestingCompileCompileLibraryAccessors = new ComGoogleTestingCompileCompileLibraryAccessors(owner);

        public ComGoogleTestingCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.testing.compile.compile</b>
         */
        public ComGoogleTestingCompileCompileLibraryAccessors getCompile() {
            return laccForComGoogleTestingCompileCompileLibraryAccessors;
        }

    }

    public static class ComGoogleTestingCompileCompileLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTestingCompileCompileLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testing</b> with <b>com.google.testing.compile:compile-testing</b> coordinates and
         * with version reference <b>com.google.testing.compile.compile.testing</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("com.google.testing.compile.compile.testing");
        }

    }

    public static class ComGoogleTruthLibraryAccessors extends SubDependencyFactory {

        public ComGoogleTruthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>truth</b> with <b>com.google.truth:truth</b> coordinates and
         * with version reference <b>com.google.truth.truth</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTruth() {
            return create("com.google.truth.truth");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleAutoVersionAccessors vaccForComGoogleAutoVersionAccessors = new ComGoogleAutoVersionAccessors(providers, config);
        private final ComGoogleGuavaVersionAccessors vaccForComGoogleGuavaVersionAccessors = new ComGoogleGuavaVersionAccessors(providers, config);
        private final ComGoogleTestingVersionAccessors vaccForComGoogleTestingVersionAccessors = new ComGoogleTestingVersionAccessors(providers, config);
        private final ComGoogleTruthVersionAccessors vaccForComGoogleTruthVersionAccessors = new ComGoogleTruthVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.auto</b>
         */
        public ComGoogleAutoVersionAccessors getAuto() {
            return vaccForComGoogleAutoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.guava</b>
         */
        public ComGoogleGuavaVersionAccessors getGuava() {
            return vaccForComGoogleGuavaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.testing</b>
         */
        public ComGoogleTestingVersionAccessors getTesting() {
            return vaccForComGoogleTestingVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.truth</b>
         */
        public ComGoogleTruthVersionAccessors getTruth() {
            return vaccForComGoogleTruthVersionAccessors;
        }

    }

    public static class ComGoogleAutoVersionAccessors extends VersionFactory  {

        private final ComGoogleAutoAutoVersionAccessors vaccForComGoogleAutoAutoVersionAccessors = new ComGoogleAutoAutoVersionAccessors(providers, config);
        public ComGoogleAutoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.auto.auto</b>
         */
        public ComGoogleAutoAutoVersionAccessors getAuto() {
            return vaccForComGoogleAutoAutoVersionAccessors;
        }

    }

    public static class ComGoogleAutoAutoVersionAccessors extends VersionFactory  {

        public ComGoogleAutoAutoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.auto.auto.common</b> with value <b>1.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCommon() { return getVersion("com.google.auto.auto.common"); }

    }

    public static class ComGoogleGuavaVersionAccessors extends VersionFactory  {

        public ComGoogleGuavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.guava.guava</b> with value <b>33.1.0-jre</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGuava() { return getVersion("com.google.guava.guava"); }

    }

    public static class ComGoogleTestingVersionAccessors extends VersionFactory  {

        private final ComGoogleTestingCompileVersionAccessors vaccForComGoogleTestingCompileVersionAccessors = new ComGoogleTestingCompileVersionAccessors(providers, config);
        public ComGoogleTestingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.testing.compile</b>
         */
        public ComGoogleTestingCompileVersionAccessors getCompile() {
            return vaccForComGoogleTestingCompileVersionAccessors;
        }

    }

    public static class ComGoogleTestingCompileVersionAccessors extends VersionFactory  {

        private final ComGoogleTestingCompileCompileVersionAccessors vaccForComGoogleTestingCompileCompileVersionAccessors = new ComGoogleTestingCompileCompileVersionAccessors(providers, config);
        public ComGoogleTestingCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.testing.compile.compile</b>
         */
        public ComGoogleTestingCompileCompileVersionAccessors getCompile() {
            return vaccForComGoogleTestingCompileCompileVersionAccessors;
        }

    }

    public static class ComGoogleTestingCompileCompileVersionAccessors extends VersionFactory  {

        public ComGoogleTestingCompileCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.testing.compile.compile.testing</b> with value <b>0.21.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTesting() { return getVersion("com.google.testing.compile.compile.testing"); }

    }

    public static class ComGoogleTruthVersionAccessors extends VersionFactory  {

        public ComGoogleTruthVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.truth.truth</b> with value <b>1.4.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTruth() { return getVersion("com.google.truth.truth"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
