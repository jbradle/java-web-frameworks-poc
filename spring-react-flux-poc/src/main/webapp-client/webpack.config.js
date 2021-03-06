//noinspection JSUnresolvedVariable
export default (production) => ({
    entry: './src/app.jsx',
    output: {
        path: __dirname,
        filename: 'app.js'
    },
    debug: !production,
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
    devtool: !production ? 'eval-source-map' : ''
});
