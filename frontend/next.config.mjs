/** @type {import('next').NextConfig} */
const nextConfig = {
    redirects: () => {
        return [ {
            basePath: false,
            source: "/",
            destination: "/login",
            permanent: true
        }]
    }
};

export default nextConfig;