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

export function post(url, payload) {
    return new Promise((resolve, reject) => {
        superagent
            .post(url)
            .send(payload)
            .set('Content-Type', 'application/json')
            .set('Accept', 'application/json')
            .end((err, res) => {
                if (err) {
                    reject(err);
                } else {
                    resolve(res.body);
                }
            });
    });
}

export function del(url, payload) {
    return new Promise((resolve, reject) => {
        superagent
            .del(url)
            .send(payload)
            .set('Content-Type', 'application/json')
            .set('Accept', 'application/json')
            .end((err, res) => {
                if (err) {
                    reject(err);
                } else {
                    resolve(res.body);
                }
            });
    });
}