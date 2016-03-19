import React from "react";
import {Link} from "react-router";


class Add extends React.Component {

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <div className="list-group">
                        <Link to="/" className="list-group-item ">Framework List</Link>
                        <Link to="add" className="list-group-item active">Add Framework</Link>
                        <Link to="search" className="list-group-item">Search</Link>
                    </div>
                </div>
                <div className="col-md-8">
                    <div className="well">
                        <h4>Add New Framework</h4>

                        <form name="addFramework" method="post">
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label for="name">Name:</label>
                                    <input type="text" className="form-control" id="name"/>

                                    <p className="help-block"/>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label for="description">Description:</label>
                                    <textarea className="form-control" rows="3" id="description"/>

                                    <div className="help-block"></div>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <div className="controls">
                                    <label for="docLink">Documentation Link:</label>
                                    <input type="text" className="form-control" id="docLink"/>

                                    <div className="help-block"></div>
                                </div>
                            </div>
                            <div className="control-group form-group">
                                <label for="categorySelect">Category:</label>
                                <select className="form-control" id="categorySelect">
                                    <option>Web Layer</option>
                                    <option>Service Layer</option>
                                    <option>Data Layer</option>
                                </select>
                            </div>
                            <div id="success"></div>
                            <button type="submit" className="btn btn-primary">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Add;