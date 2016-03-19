import React from "react";
import {Link} from "react-router";

import FrameworkTable from "../components/FrameworkTable.jsx";

class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: [1, 2],
            loading: false
        };
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <div className="list-group">
                        <Link to="/" className="list-group-item">Framework List</Link>
                        <Link to="add" className="list-group-item">Add Framework</Link>
                        <Link to="search" className="list-group-item active">Search</Link>
                    </div>
                </div>

                <div className="col-md-8">
                    <div className="well">
                        <form action="#">
                            <label htmlFor="search">Framework Search</label>
                            <div className="input-group">
                                <input type="text" className="form-control" id="search" name="searchParam"/>
                        <span className="input-group-btn">
                            <button className="btn btn-default" type="submit"><i className="fa fa-search"/></button>
                        </span>
                            </div>
                        </form>
                    </div>
                    <FrameworkTable {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Home;