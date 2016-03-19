import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute } from 'react-router';
import { hashHistory } from 'react-router'

import Main from './view/main.jsx';
import Home from './view/home.jsx';
import Add from './view/add.jsx';
import Search from './view/search.jsx';

/*
 Routes
 */
const routes = (
    <Router history={hashHistory}>
        <Route path='/' component={ Main }>
            <IndexRoute component={ Home }/>
            <Route path='home' component={ Home } />
            <Route path='add' component={ Add } />
            <Route path='search' component={ Search } />
        </Route>
    </Router>
);

ReactDOM.render(routes, document.getElementById('app'));
