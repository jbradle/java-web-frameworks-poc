export default (dev) => ({
    entry: './src/app.js',
    output: {
        path: __dirname,
        filename: 'app.js'
    },
    debug: false,
    module: {
        loaders: [{
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel',
            query: {
                presets: ['react', 'es2015']
            }
        }]
    },
    devtool: dev ? 'eval' : {}
});