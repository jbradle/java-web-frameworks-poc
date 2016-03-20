import superagent from "superagent";
import Promise from "promise-polyfill";


export function get(url) {
    return new Promise((resolve, reject) => {
        superagent
            .get(url)
            .accept("json")
            .end((err, res) => {
                if (err) {
                    reject(err);
                } else {
                    resolve(res.body);
                }
            });
    });
}